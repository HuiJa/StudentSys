package org.studentSys.dao;

import org.studentSys.entity.Student;
import org.studentSys.enums.SexEnums;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.studentSys.enums.SmajorEnums;
import org.studentSys.enums.SpeoEnums;

import javax.annotation.Resource;

/**
 * Created by HuiJa on 2018/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring-config/spring-dao.xml"})
public class StudentDaoTest {

    //这边注入一直显示错误,但其实没有错
    @Resource
    private StudentDao studentDao;

    @Test
    public void insertStudent() throws Exception {
        //如果我int类型开头写0默认为8进制,那么如果有8会报错,
        Student student = new Student(8148888, "王大锤", SexEnums.男, SmajorEnums.计科,2014,"2班","梅二A318","17501520888","江苏南京", SpeoEnums.汉,"江苏无锡","15061880888");
        studentDao.insertStudent(student);
    }

    @Test
    public void queryPasswd() throws Exception {
        int sid = 8148888;
        System.out.println(studentDao.queryPasswd(sid));
    }

    @Test
    public void queryBySid() throws Exception {
        int sid=8148888;
        Student student=studentDao.queryBySid(sid);
        System.out.println(student.toString());
    }

}