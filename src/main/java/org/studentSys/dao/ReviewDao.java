package org.studentSys.dao;

import org.apache.ibatis.annotations.Param;
import org.studentSys.entity.Review;
import org.studentSys.enums.EvaluatorEnums;

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
     * 2.根据学号,评价人查询评价
     * @param sid
     * @return
     */
    List<Review> queryReviews(@Param("sid")int sid,@Param("rtype") EvaluatorEnums rtype);

    /**
     * 3.删除评论
     * @param rid
     */
    void deleteReview(int rid);
}
