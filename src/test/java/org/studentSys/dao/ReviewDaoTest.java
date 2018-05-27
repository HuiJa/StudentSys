package org.studentSys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.studentSys.entity.Review;
import org.studentSys.enums.EvaluatorEnums;
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
public class ReviewDaoTest {
    @Resource
    private ReviewDao reviewDao;

    @Test
    public void insertReview() throws Exception {
        Review review = new Review(8148888, EvaluatorEnums.自己, "毕业后还得继续努力啊", DateFormatUtil.dateFormat("2018-5-1"));
        reviewDao.insertReview(review);
    }

    @Test
    public void queryReviewsBySid() throws Exception {
        List<Review> reviewList = reviewDao.queryReviews(8148888,EvaluatorEnums.教师);
        for (Review review : reviewList) {
            System.out.println(review);
        }
    }

}