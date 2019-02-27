package org.studentSys.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by HuiJa on 2018/5/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void teacherLogin() throws Exception {
        System.out.println(teacherService.teacherLogin(8148888,"now888"));
    }

}