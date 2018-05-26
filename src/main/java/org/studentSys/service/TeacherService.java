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
    /**
     * 2.修改密码
     * @param tid
     * @param tpasswd
     * @return 0修改成功 -1修改失败
     */
    int teacherPasswd(int tid,String tpasswd);
}
