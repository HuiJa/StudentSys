package org.studentSys.dao;

import org.studentSys.entity.Student;

/**
 * Created by HuiJa on 2018/4/26.
 */
public interface StudentDao {
    /**
     * 1.插入一条学生数据
     *
     * @param student
     */
    void insertStudent(Student student);

    /**
     * 2.根据学号查询密码,dao名query,service名get
     *
     * @param sid
     * @return
     */
    String queryPasswd(int sid);

    /**
     * 3.根据学号获取学生对象
     * @param sid
     * @return
     */
    Student queryBySid(int sid);
}
