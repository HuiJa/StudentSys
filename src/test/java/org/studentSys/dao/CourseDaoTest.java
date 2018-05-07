package org.studentSys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.studentSys.entity.Course;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by HuiJa on 2018/5/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring-config/spring-dao.xml"})
public class CourseDaoTest {
    @Resource
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