package org.studentSys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Override
    @Transactional
    public int teacherPasswd(int sid, String spasswd) {
        String oldPasswd = teacherDao.queryPasswd(sid);
        String newPasswd = EncryptionUtil.StrEncoder(spasswd, "SHA-256");
        teacherDao.changePasswd(sid, newPasswd);
        if (oldPasswd.equals(teacherDao.queryPasswd(sid)) == false) {
            return 0;//改密成功
        } else return 1;
    }
}
