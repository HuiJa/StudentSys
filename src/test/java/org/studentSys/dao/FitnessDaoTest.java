package org.studentSys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.studentSys.entity.Fitness;

import javax.annotation.Resource;

/**
 * Created by HuiJa on 2018/5/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring-config/spring-dao.xml"})
public class FitnessDaoTest {
    //这边注入一直显示错误,但其实没有错
    @Resource
    private FitnessDao fitnessDao;

    @Test
    public void insertFitness() throws Exception {
        Fitness fitness = new Fitness(8148888, 2, 176, 76, 7.3, 240, 3.40, 6, 8.8);
        fitnessDao.insertFitness(fitness);
    }

    @Test
    public void queryFitness() throws Exception {
        Fitness fitness=fitnessDao.queryFitness(8148888, 2);
        System.out.println(fitness.toString());
    }

}