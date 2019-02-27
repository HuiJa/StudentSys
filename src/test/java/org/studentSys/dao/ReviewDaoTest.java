package org.studentSys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.studentSys.entity.Review;
import org.studentSys.enums.EvaluatorEnums;
import org.studentSys.util.DateFormatUtil;

import java.util.List;

/**
 * Created by HuiJa on 2018/5/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewDaoTest {
    @Autowired
    private ReviewDao reviewDao;

    @Test
    public void insertReview() throws Exception {
        Review review = new Review(8148888, EvaluatorEnums.自己, "毕业后还得继续努力啊", DateFormatUtil.dateFormat("2018-5-1"));
        reviewDao.insertReview(review);
    }

    @Test
    public void queryReviewsBySid() throws Exception {
        List<Review> reviewList = reviewDao.queryReviews(8148888, EvaluatorEnums.教师);
        for (Review review : reviewList) {
            System.out.println(review);
        }
    }
    @Test
    public void deleteReview() throws Exception{
        reviewDao.deleteReview(10);
    }

}