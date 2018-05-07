package org.studentSys.dao;

import org.studentSys.entity.Course;

/**
 * Created by HuiJa on 2018/5/7.
 */
public interface CourseDao {
    /**
     * 1.插入一条课程信息
     * @param course
     */
    void insertCourse(Course course);

    /**
     * 2.根据cid查询课程信息
     * @param cid
     */
    Course queryCourse(int cid);
}
