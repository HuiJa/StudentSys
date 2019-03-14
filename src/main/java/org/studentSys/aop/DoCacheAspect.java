package org.studentSys.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.studentSys.annotation.DoCache;
import org.studentSys.util.SpelParser;

import java.lang.reflect.Method;

@Component
@Aspect
public class DoCacheAspect {

    // 连接点ProceedingJoinPoint
    // 切入加了DoCache注解的方法
    @Around("@annotation(doCache)")
    public Object doArount(ProceedingJoinPoint proceedingJoinPoint, DoCache doCache) throws Throwable {
        // 拿到当前方法和注解实例, 打印注解元数据
//        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
//        DoCache doCache=method.getAnnotation(DoCache.class);
//        System.out.println(doCache.key());
        System.out.println(getKey(doCache.key(),proceedingJoinPoint));
        System.out.println("===========相关方法开始执行======");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("===========相关方法执行结束======");
        return result;
    }

    // 获取方法参数拼接我们真实的key
    private String getKey(String key, ProceedingJoinPoint proceedingJoinPoint) {
        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
        String[] parameterNames = new LocalVariableTableParameterNameDiscoverer().getParameterNames(method);
        return SpelParser.getKey(key,parameterNames,proceedingJoinPoint.getArgs());
    }
}
