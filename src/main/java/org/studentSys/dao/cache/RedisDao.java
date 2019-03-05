package org.studentSys.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.studentSys.dto.CacheEntry;
import org.studentSys.dto.StudentGrade;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;

@Component
public class RedisDao {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JedisPool jedisPool;

    //protostuff schema, 类型跟想要的value对应, 这里是ArrayList(但是报错了), 这样序列号只用String类型就够了,redis
    //private RuntimeSchema<ArrayList> schema = RuntimeSchema.createFrom(ArrayList.class);
    private RuntimeSchema<CacheEntry> schema = RuntimeSchema.createFrom(CacheEntry.class);

    /*public RedisDao(String ip, int port) {
        jedisPool = new JedisPool(ip, port);
    }*/

    /**
     * @param sid
     * @return 从redis内取数据
     */
    public ArrayList<StudentGrade> getGrades(int sid, int cyear) {
        //redis操作逻辑
        try {
            //获取jedis对象
            Jedis jedis = jedisPool.getResource();
            try {
                //用于取数据的key
                String key = cyear + "grades:" + sid;
                // 采用自定义序列化protostuff, 效率+空间
                // 尝试获取value
                byte[] bytes = jedis.get(key.getBytes());
                if (bytes != null) {
                    //空对象接受反序列化的内容并返回
                    //包装一层,来适配protostuff的序列号api
                    CacheEntry cacheEntry=schema.newMessage();
                    //反序列化
                    ProtostuffIOUtil.mergeFrom(bytes, cacheEntry, schema);
                    //得到想要的结果
                    ArrayList<StudentGrade> studentGrades = cacheEntry.getstudentGrades();
                    return studentGrades;
                }
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public String putstudentGrades(ArrayList<StudentGrade> studentGrades, int cyear) {
        // set Object(Seckill) -> 序列化 -> byte[]
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                //用于存数据的key, 直接取List第一个
                String key = cyear + "grades:" + studentGrades.get(0).getSid();
                CacheEntry cacheEntry=new CacheEntry(studentGrades);
                //将传入的studentGrades序列号
                byte[] bytes = ProtostuffIOUtil.toByteArray(cacheEntry, schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                //超时缓存1小时, key-->bytes
                int timeout = 60 * 60;
                String result = jedis.setex(key.getBytes(), timeout, bytes);
                return result;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

}
