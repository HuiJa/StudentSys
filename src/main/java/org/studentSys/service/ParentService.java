package org.studentSys.service;

import org.studentSys.entity.Student;

/**
 * Created by HuiJa on 2018/5/31.
 */
public interface ParentService {
    /**
     * @param pid
     * @param ppasswd
     * @return 登录
     */
    int parentLogin(int pid, String ppasswd);

    /**
     * @param pid
     * @return 该家长的学生信息
     */
    Student getStudent(int pid);

    /**
     * @param sid
     * @param spasswd
     * @return 修改密码
     */
    int parentPasswd(int sid, String spasswd);
}
