package org.studentSys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.studentSys.entity.Course;

/**
 * Created by HuiJa on 2018/5/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseDaoTest {
    @Autowired
    private CourseDao courseDao;

    @Test
    public void insertCourse() throws Exception {
        Course course = new Course(2014115, "C++程序语言设计", 1);
        courseDao.insertCourse(course);
    }

    @Test
    public void queryCourse() throws Exception {
        System.out.println(courseDao.queryCourse(2014111));
    }

}