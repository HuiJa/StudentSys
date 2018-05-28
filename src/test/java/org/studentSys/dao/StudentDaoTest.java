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
import java.util.List;

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
        //因为我个人在sql里加入了ignore,所以即使同样主键也不会报错,但是并不会执行
        //如果我int类型开头写0默认为8进制,那么如果有8会报错,
        Student student = new Student(8148888, "王大锤", SexEnums.男, SmajorEnums.计科, 1, "梅二A318", "17501520888", "江苏南京", SpeoEnums.汉, "江苏无锡", "15061880888");
        studentDao.insertStudent(student);
    }

    @Test
    public void queryPasswd() throws Exception {
        int sid = 8148888;
        System.out.println(studentDao.queryPasswd(sid));
    }

    @Test
    public void queryStudent() throws Exception {
        int sid = 8148888;
        Student student = studentDao.queryStudent(sid);
        System.out.println(student.toString());
    }

    @Test
    public void changeSresult() throws Exception {
        studentDao.changeSresult(8148888, "工作(南京)");
        studentDao.changeSresult(8147777, "保研(华中科技大学)");
        studentDao.changeSresult(8146666, "考公(北京)");
    }

    @Test
    public void queryByLike() throws Exception {
        List<Student> students = studentDao.queryByLike("考公");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void changePasswd() throws Exception {
        //123456
        studentDao.changePasswd(8148888, "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92");
    }

    @Test
    public void queryTeacher() throws Exception {
        System.out.println(studentDao.queryTeacher(1));
    }

    @Test
    public void queryGrades() throws Exception {
        System.out.println(studentDao.queryGrades(8146666,1));
    }
}