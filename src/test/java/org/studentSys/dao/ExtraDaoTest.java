package org.studentSys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.studentSys.entity.Extra;
import org.studentSys.enums.EvaluatorEnums;
import org.studentSys.enums.ExtraDevEnums;
import org.studentSys.util.DateFormatUtil;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by HuiJa on 2018/5/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring-config/spring-dao.xml"})
public class ExtraDaoTest {
    @Resource
    private ExtraDao extraDao;

    @Test
    public void insertExtra() throws Exception {
        Extra extra = new Extra(8148888, ExtraDevEnums.锻炼, "每天晚上都进行仰卧起坐", DateFormatUtil.dateFormat("2014-9-1"), DateFormatUtil.dateFormat("2018-6-30"));
        extraDao.insertExtra(extra);
    }

    @Test
    public void queryExtrasBySid() throws Exception {
        List<Extra> extraList = extraDao.queryExtrasBySid(8148888);
        //System.out.println(extraList.toString());后者输出会换行
        for (Extra extra : extraList) {
            System.out.println(extra.toString());
        }
    }

}