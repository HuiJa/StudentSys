package org.studentSys.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by HuiJa on 2018/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-config/spring-dao.xml",
        "classpath:spring-config/spring-service.xml"})
public class StudentServiceTest {
    //创建日志对象
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *
     */
    //注入依赖
    @Autowired
    private StudentService studentService;

    @Test
    public void studentLogin() throws Exception {
        System.out.println(studentService.studentLogin(8148888,"now888"));
    }

}