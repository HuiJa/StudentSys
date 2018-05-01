package org.studentSys.service;

/**
 * Created by HuiJa on 2018/4/26.
 */
public interface StudentService {
    /**
     * 1. 学生登录
     * @param sid
     * @param spasswd
     * @return 0,登录正常 -1,登录失败
     */
    int studentLogin(int sid, String spasswd);
}
