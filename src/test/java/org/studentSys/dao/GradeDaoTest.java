package org.studentSys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.studentSys.entity.Grade;
import org.studentSys.util.DateFormatUtil;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by HuiJa on 2018/5/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring-config/spring-dao.xml"})
public class GradeDaoTest {
    @Resource
    private GradeDao gradeDao;

    @Test
    public void insertGrade() throws Exception {
        Grade grade = new Grade(2014115, 8148888, 77, DateFormatUtil.dateFormat("2014-9-1"));
        gradeDao.insertGrade(grade);
    }

    @Test
    public void queryGradesBySid() throws Exception {
        List<Grade> gradeList = gradeDao.queryGradesBySid(8148888);
        for (Grade grade : gradeList) {
            System.out.println(grade);
        }
    }

}