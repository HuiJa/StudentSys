package org.studentSys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.studentSys.entity.Extra;
import org.studentSys.enums.ExtraDevEnums;
import org.studentSys.util.DateFormatUtil;

import java.util.List;

/**
 * Created by HuiJa on 2018/5/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtraDaoTest {
    @Autowired
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