package org.studentSys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.studentSys.entity.Teacher;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by HuiJa on 2018/5/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring-config/spring-dao.xml"})
public class TeacherDaoTest {
    @Resource
    private TeacherDao teacherDao;

    @Test
    public void queryTeacher() throws Exception {
        Teacher teacher=teacherDao.queryTeacher(8148888);
        System.out.println(teacher.toString());
    }

}