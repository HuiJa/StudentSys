package org.studentSys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.studentSys.entity.Grade;
import org.studentSys.util.DateFormatUtil;

import java.util.List;

/**
 * Created by HuiJa on 2018/5/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GradeDaoTest {
    @Autowired
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