package org.studentSys.dao;

import org.apache.ibatis.annotations.Param;
import org.studentSys.entity.Student;

import java.util.List;

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
    Student queryStudent(int sid);

    /**
     * 4.修改学生去向
     * @param sid
     * @param sresult
     */
    void changeSresult(@Param("sid") int sid,@Param("sresult") String sresult);

    /**
     * 5.模糊查询
     * @param likeString
     * @return
     */
    List<Student> queryByLike(String likeString);
}
