package org.studentSys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.studentSys.dao.TeacherDao;
import org.studentSys.service.TeacherService;
import org.studentSys.util.EncryptionUtil;

/**
 * Created by HuiJa on 2018/5/8.
 */
@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public int teacherLogin(int tid, String tpasswd) {
        if (EncryptionUtil.StrEncoder(tpasswd,"SHA-256").equals(teacherDao.queryPasswd(tid))) {
            return 0;
        }
        return -1;
    }
}
