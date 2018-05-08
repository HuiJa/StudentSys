package org.studentSys.dao;

import org.studentSys.entity.Teacher;

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

}
