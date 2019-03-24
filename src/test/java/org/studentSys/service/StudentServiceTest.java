package org.studentSys.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.studentSys.dto.StudentGrade;

import java.util.ArrayList;

/**
 * Created by HuiJa on 2018/4/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    //创建日志对象
    //private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //注入依赖
    @Autowired
    private StudentService studentService;

    @Test
    public void studentLogin() throws Exception {
        System.out.println(studentService.studentLogin(8148888,"now888"));
    }

    @Test
    public void studentPasswd() throws Exception {
        System.out.println(studentService.studentPasswd(8148888,"123456"));
    }
    @Test
    public void getCourse() throws Exception {
        ArrayList<StudentGrade> arrayList = studentService.getSudentGrades(8146666, 1);
        String[] courses = new String[arrayList.size()];
        int i = 0;
        for (StudentGrade studentGrade : arrayList) {
            courses[i] = studentGrade.getCname();
            i++;
        }
        for (String course:courses) {
            System.out.println(course);
        }
    }
}