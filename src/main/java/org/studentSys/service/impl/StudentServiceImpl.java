package org.studentSys.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.studentSys.annotation.DoArrayListCache;
import org.studentSys.dao.cache.RedisDao;
import org.studentSys.dao.ReviewDao;
import org.studentSys.dao.StudentDao;
import org.studentSys.dto.StudentGrade;
import org.studentSys.entity.Review;
import org.studentSys.entity.Student;
import org.studentSys.enums.EvaluatorEnums;
import org.studentSys.service.StudentService;
import org.studentSys.util.EncryptionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuiJa on 2018/4/26.
 */
@Service
public class StudentServiceImpl implements StudentService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    //注入dao依赖
    @Autowired
    private RedisDao redisDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private ReviewDao reviewDao;

    // 可以使用多个 redis 实例或同一个 redis 中的不同 db 来做不同模块的缓存, 来解决重复状况, 我这里就不需要了
    // private static final String CACHE_NAME = "Grades";
    // 如果需要事务可以使用@Transactional注解

    /**
     * 1.学生登录
     *
     * @param sid
     * @param spasswd
     * @return
     */
    @Override
    public int studentLogin(int sid, String spasswd) {
        if (EncryptionUtil.StrEncoder(spasswd, "SHA-256").equals(studentDao.queryPasswd(sid))) {
            log.info("====>>" + sid + "登录成功");
            return 0;
        }
        log.info("====>>" + sid + "登录失败");
        return -1;
    }

    /**
     * 2.密码修改
     *
     * @param sid
     * @param spasswd
     * @return
     */
    @Override
    @Transactional
    public int studentPasswd(int sid, String spasswd) {
        String oldPasswd = studentDao.queryPasswd(sid);
        String newPasswd = EncryptionUtil.StrEncoder(spasswd, "SHA-256");
        if (oldPasswd.equals(newPasswd) == false) {
            studentDao.changePasswd(sid, newPasswd);
            if (oldPasswd.equals(studentDao.queryPasswd(sid)) == false) {
                log.info("====>>" + sid + "改密成功");
                return 0;//改密成功
            } else {
                log.info("====>>" + sid + "改密两次输入密码不一致");
                return 1;
            }
        } else {
            log.info("====>>" + sid + "改密使用了旧的密码");
            return 1;
        }

    }

    /**
     * 3.查询评价表
     *
     * @param student
     * @return 改成
     */
    @Override
    public List<Review> teacherReview(Student student) {
        return reviewDao.queryReviews(student.getSid(), EvaluatorEnums.教师);
    }

    @Override
    public List<Review> studentReview(Student student) {
        return reviewDao.queryReviews(student.getSid(), EvaluatorEnums.同学);
    }

    @Override
    public List<Review> parentReview(Student student) {
        return reviewDao.queryReviews(student.getSid(), EvaluatorEnums.家长);
    }

    @Override
    public List<Review> ownReview(Student student) {
        return reviewDao.queryReviews(student.getSid(), EvaluatorEnums.自己);
    }

    @Override
    @DoArrayListCache(key = "#cyear + 'StudentGrade:' + #sid")
    public ArrayList<StudentGrade> getSudentGrades(int sid, int cyear) {
        return (ArrayList) studentDao.queryGrades(sid, cyear);
        //return studentGrades;
    }
}
