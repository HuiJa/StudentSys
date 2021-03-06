package org.studentSys.dao;

import org.apache.ibatis.annotations.Param;
import org.studentSys.entity.Student;
import org.studentSys.entity.Teacher;

import java.util.List;

/**
 * Created by HuiJa on 2018/5/7.
 */
public interface TeacherDao {
    /**
     * 1.查询老师信息
     * @param tid
     * @return
     */
    Teacher queryTeacher(int tid);
    /**
     * 2.根据工号查询密码,dao名query,service名get
     *
     * @param tid
     * @return
     */
    String queryPasswd(int tid);
    /**
     * 3.修改密码
     *
     * @param tpasswd
     */
    void changePasswd(@Param("tid") int tid, @Param("tpasswd") String tpasswd);

    /**
     * 4.查询某班学生列表
     * @param Xid
     * @return
     */
    List<Student> queryByXid(int Xid);
}
