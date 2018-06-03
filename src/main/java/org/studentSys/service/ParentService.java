package org.studentSys.service;

import org.springframework.transaction.annotation.Transactional;
import org.studentSys.entity.Student;

/**
 * Created by HuiJa on 2018/5/31.
 */
public interface ParentService {
    int parentLogin(int pid, String ppasswd);

    Student getStudent(int pid);

    int parentPasswd(int sid, String spasswd);
}
