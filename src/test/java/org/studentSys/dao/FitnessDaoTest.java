package org.studentSys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.studentSys.entity.Fitness;

/**
 * Created by HuiJa on 2018/5/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FitnessDaoTest {


    //这边注入一直显示错误,但其实没有错,改一下判断等级就好了
    @Autowired
    private FitnessDao fitnessDao;

    @Test
    public void insertFitness() throws Exception {
        Fitness fitness = new Fitness(8148888, 2, 176, 76, 7.3, 240, 3.40, 6, 8.8);
        fitnessDao.insertFitness(fitness);
    }

    @Test
    public void queryFitness() throws Exception {
        Fitness fitness = fitnessDao.queryFitness(8148888, 2);
        System.out.println(fitness.toString());
    }


}