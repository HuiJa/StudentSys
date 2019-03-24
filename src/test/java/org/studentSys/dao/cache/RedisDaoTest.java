package org.studentSys.dao.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.studentSys.dao.StudentDao;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDaoTest {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisDao redisDao;
    @Autowired
    private StudentDao studentDao;

    @Test
    public void testRedis() throws Exception {
        //get and put
        log.info("====>>redis测试开始");
        ArrayList<Object> studentGrades = redisDao.getArrayListBykey("1");
        if (studentGrades == null) {
            log.info("====>>当前数据没有缓存");
            studentGrades = (ArrayList) studentDao.queryGrades(8148888, 1);
            //System.out.println(studentGrades.toString());
            if (studentGrades != null) {
                String result = redisDao.putArrayList(studentGrades, "1");
                System.out.println(result);
                studentGrades = redisDao.getArrayListBykey("1");
                log.info("====>>数据缓存成功");
                System.out.println(studentGrades.toString());
            }
        }else {
            log.info("====>>当前数据已缓存");
            System.out.println(studentGrades.toString());
        }
        log.info("====>>redis测试结束");
    }
}