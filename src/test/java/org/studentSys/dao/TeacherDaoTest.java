package org.studentSys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.studentSys.entity.Teacher;

/**
 * Created by HuiJa on 2018/5/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherDaoTest {
    @Autowired
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