package org.studentSys.dao;

import org.apache.ibatis.annotations.Param;
import org.studentSys.entity.Fitness;

import java.util.List;

/**
 * Created by HuiJa on 2018/5/1.
 */
public interface FitnessDao {
    /**
     * 1.插入一条体侧记录
     *
     * @param fitness
     */
    void insertFitness(Fitness fitness);

    /**
     * 2.根据学号和测试学年查询体测信息
     * @param sid
     * @param fyear
     * @return
     */
    Fitness queryFitness(@Param("sid") int sid, @Param("fyear") int fyear);

    /**
     * 3.根据学号查询各项体测信息
     * @param sid
     * @return
     */
    Double[] queryFheigBySid(int sid);
    Double[] queryFweigBySid(int sid);
    Double[] queryFrunBySid(int sid);
    Double[] queryFjumpBySid(int sid);
    Double[] queryFwalkBySid(int sid);
    Double[] queryFupBySid(int sid);
    Double[] queryFaheadBySid(int sid);
}
