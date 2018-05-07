package org.studentSys.dao;

import org.studentSys.entity.Extra;

import java.util.List;

/**
 * Created by HuiJa on 2018/5/7.
 */
public interface ExtraDao {
    /**
     * 1.插入一条课外发展信息
     * @param extra
     */
    void insertExtra(Extra extra);

    /**
     * 2.根据学号查询课外发展记录
     * @param Sid
     * @return
     */
    List<Extra> queryExtrasBySid(int Sid);
}
