package org.studentSys.dao;

import org.studentSys.entity.Grade;

import java.util.List;

/**
 * Created by HuiJa on 2018/5/7.
 */
public interface GradeDao {
    /**
     * 1.插入一条成绩信息
     *
     * @param grade
     */
    void insertGrade(Grade grade);

    /**
     * 2.根据学号查询成绩
     *
     * @param sid
     * @return
     */
    List<Grade> queryGradesBySid(int sid);
}
