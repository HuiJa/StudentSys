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
        Teacher teacher = teacherDao.queryTeacher(8143888);
        if (teacher != null) {
            System.out.println(teacher.toString());
        }
    }

    @Test
    public void queryPasswd() throws Exception {
        int tid = 8148888;
        System.out.println(teacherDao.queryPasswd(tid));
    }

    @Test
    public void queryByXid() throws Exception {
        int xid = 1;
        System.out.println(teacherDao.queryByXid(xid));
    }
}