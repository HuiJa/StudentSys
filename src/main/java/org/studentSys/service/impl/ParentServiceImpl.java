package org.studentSys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.studentSys.dao.ParentDao;
import org.studentSys.dao.StudentDao;
import org.studentSys.entity.Student;
import org.studentSys.service.ParentService;
import org.studentSys.util.EncryptionUtil;

/**
 * Created by HuiJa on 2018/5/31.
 */
@Service
public class ParentServiceImpl implements ParentService{
    @Autowired
    ParentDao parentDao;
    @Autowired
    StudentDao studentDao;

    @Override
    public int parentLogin(int pid, String ppasswd) {
        if (EncryptionUtil.StrEncoder(ppasswd, "SHA-256").equals(parentDao.queryPasswd(pid))) {
            return 0;
        }
        return -1;
    }

    @Override
    @Transactional
    public Student getStudent(int pid){
        return studentDao.queryStudent(parentDao.querySid(pid));
    }

    @Override
    @Transactional
    public int parentPasswd(int pid, String ppasswd) {
        String oldPasswd = parentDao.queryPasswd(pid);
        String newPasswd = EncryptionUtil.StrEncoder(ppasswd, "SHA-256");
        if (oldPasswd.equals(newPasswd) == false) {
            parentDao.changePasswd(pid, newPasswd);
            if (oldPasswd.equals(parentDao.queryPasswd(pid)) == false) {
                return 0;//改密成功
            } else return 1;
        } else return 1;

    }
}
