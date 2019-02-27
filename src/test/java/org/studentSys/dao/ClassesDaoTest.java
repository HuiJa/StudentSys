package org.studentSys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by HuiJa on 2018/5/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassesDaoTest {
    @Autowired
    private ClassesDao classesDao;
    @Test
    public void queryClasses() throws Exception {
        int xid=1;
        System.out.println(classesDao.queryClasses(1));
    }

}