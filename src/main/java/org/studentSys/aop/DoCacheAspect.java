package org.studentSys.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.studentSys.annotation.DoArrayListCache;
import org.studentSys.dao.cache.RedisDao;
import org.studentSys.util.SpelParser;

import java.lang.reflect.Method;
import java.util.ArrayList;

@Component
@Aspect
public class DoCacheAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RedisDao redisDao;


    // 连接点ProceedingJoinPoint
    // 切入加了DoCache注解的方法
    @Around("@annotation(doArrayListCache)")
    public Object doArount(ProceedingJoinPoint proceedingJoinPoint, DoArrayListCache doArrayListCache) throws Throwable {
        // 拿到当前方法和注解实例, 打印注解元数据
//        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
//        DoArrayListCache doArrayListCache=method.getAnnotation(DoArrayListCache.class);
//        System.out.println(doArrayListCache.key());
        log.info("===========进入ArrayList缓存切点增强======");
        // EL类型拼接Key
        String key = getKey(doArrayListCache.key(), proceedingJoinPoint);
        ArrayList<Object> arrayList = redisDao.getArrayListBykey(key);
        if (arrayList == null) {
            try {
                //studentGrades = (ArrayList) studentDao.queryGrades(sid, cyear);
                log.info("==>去数据库取了数据");
                arrayList = (ArrayList<Object>) proceedingJoinPoint.proceed();
            } catch (Exception e) {
                log.info("====>>数据库取数据失败!");
                e.printStackTrace();
            }
            String result = redisDao.putArrayList(arrayList, key);
            if (result != null) {
                log.info("====>>第一次缓存!");
            } else {
                log.info("====>>缓存失败,请检查RedisServer时候开启");
            }
        }
        //log.info("====>>成绩:" + grade.toString());
        log.info("===========ArrayList缓存切点增强结束======");
        return arrayList;
    }

    // 获取方法参数拼接我们真实的key
    private String getKey(String key, ProceedingJoinPoint proceedingJoinPoint) {
        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
        String[] parameterNames = new LocalVariableTableParameterNameDiscoverer().getParameterNames(method);
        return SpelParser.getKey(key, parameterNames, proceedingJoinPoint.getArgs());
    }
}
