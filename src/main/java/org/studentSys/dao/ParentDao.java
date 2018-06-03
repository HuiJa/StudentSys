package org.studentSys.dao;

import org.apache.ibatis.annotations.Param;
import org.studentSys.entity.Parent;

/**
 * Created by HuiJa on 2018/5/31.
 */
public interface ParentDao {
    String queryPasswd(int pid);
    Parent queryParent(int pid);
    int querySid(int pid);
    void changePasswd(@Param("pid") int pid, @Param("ppasswd") String ppasswd);
}
