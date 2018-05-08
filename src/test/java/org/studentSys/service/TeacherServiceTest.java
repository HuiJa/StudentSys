package org.studentSys.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.studentSys.dao.TeacherDao;

import static org.junit.Assert.*;

/**
 * Created by HuiJa on 2018/5/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-config/spring-dao.xml",
        "classpath:spring-config/spring-service.xml"})
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void teacherLogin() throws Exception {
        System.out.println(teacherService.teacherLogin(8148888,"now888"));
    }

}