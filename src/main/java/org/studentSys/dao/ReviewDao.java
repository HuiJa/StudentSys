package org.studentSys.dao;

import org.studentSys.entity.Review;

import java.util.List;

/**
 * Created by HuiJa on 2018/5/7.
 */
public interface ReviewDao {
    /**
     * 1.插入一条评价
     * @param review
     */
    void insertReview(Review review);

    /**
     * 2.根据学号查询评价
     * @param sid
     * @return
     */
    List<Review> queryReviewsBySid(int sid);
}
