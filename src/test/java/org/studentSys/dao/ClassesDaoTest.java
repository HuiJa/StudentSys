package org.studentSys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by HuiJa on 2018/5/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring-config/spring-dao.xml"})
public class ClassesDaoTest {
    @Resource
    private ClassesDao classesDao;
    @Test
    public void queryClasses() throws Exception {
        int xid=1;
        System.out.println(classesDao.queryClasses(1));
    }

}