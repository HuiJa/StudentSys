package org.studentSys.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.studentSys.dao.StudentDao;
import org.studentSys.service.StudentService;
import org.studentSys.util.EncryptionUtil;

/**
 * Created by HuiJa on 2018/4/26.
 */
@Service
public class StudentServiceImpl implements StudentService {
    //创建日志对象
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //注入dao依赖
    @Autowired
    private StudentDao studentDao;

    //如果需要事务可以使用@Transactional注解

    /**
     * 1.学生登录
     * @param sid
     * @param spasswd
     * @return
     */
    @Override
    public int studentLogin(int sid, String spasswd) {
        if (EncryptionUtil.StrEncoder(spasswd,"SHA-256").equals(studentDao.queryPasswd(sid))) {
            return 0;
        }
        return -1;
    }
}
