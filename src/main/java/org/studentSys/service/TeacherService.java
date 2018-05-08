package org.studentSys.service;

/**
 * Created by HuiJa on 2018/5/8.
 */
public interface TeacherService {
    /**
     * 1.教师登录
     * @param tid
     * @param tpasswd
     * @return 0,登录正常 -1,登录失败
     */
    int teacherLogin(int tid,String tpasswd);
}
