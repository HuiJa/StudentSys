package org.studentSys.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.studentSys.dao.ReviewDao;
import org.studentSys.dao.StudentDao;
import org.studentSys.entity.Review;
import org.studentSys.entity.Student;
import org.studentSys.enums.EvaluatorEnums;
import org.studentSys.service.StudentService;
import org.studentSys.util.EncryptionUtil;

import java.util.List;

/**
 * Created by HuiJa on 2018/4/26.
 */
@Service
public class StudentServiceImpl implements StudentService {
    //创建日志对象,比如异常的时候记录一下啊什么的,懒得弄.
    //private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //注入dao依赖
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private ReviewDao reviewDao;

    //如果需要事务可以使用@Transactional注解

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
            return 0;
        }
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
                return 0;//改密成功
            } else return 1;
        } else return 1;

    }

    /**
     * 3.查询评价表
     * @param student
     * @return
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
    public List<Review> ownReview(Student student) {
        return reviewDao.queryReviews(student.getSid(), EvaluatorEnums.自己);
    }
}
