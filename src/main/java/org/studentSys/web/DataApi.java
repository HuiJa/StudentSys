package org.studentSys.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.studentSys.dao.FitnessDao;
import org.studentSys.service.StudentService;

/**
 * Created by HuiJa on 2018/5/27.
 */
//@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class DataApi {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    StudentService studentService;
    @Autowired
    FitnessDao fitnessDao;

    //成绩相关
    @RequestMapping(value = "/course")
    public String[] getCourse(@RequestParam("sid") int sid, @RequestParam("cyear") int cyear) {
        //log.info("====>>课程查询"+sid+" "+cyear);
        return studentService.getCourse(sid, cyear);
    }

    @RequestMapping(value = "/grade")
    public int[] getGrade(@RequestParam("sid") int sid, @RequestParam("cyear") int cyear) {
        //log.info("====>>成绩查询"+sid+" "+cyear);
        return studentService.getGrade(sid, cyear);
    }

    //体测相关
    @RequestMapping(value = "/fheig")
    public Double[] getFheig(@RequestParam("sid") int sid) {
        return fitnessDao.queryFheigBySid(sid);
    }

    @RequestMapping(value = "/fweig")
    public Double[] getFweig(@RequestParam("sid") int sid) {
        return fitnessDao.queryFweigBySid(sid);
    }

    @RequestMapping(value = "/frun")
    public Double[] getFrun(@RequestParam("sid") int sid) {
        return fitnessDao.queryFrunBySid(sid);
    }

    @RequestMapping(value = "/fjump")
    public Double[] getFjump(@RequestParam("sid") int sid) {
        return fitnessDao.queryFjumpBySid(sid);
    }

    @RequestMapping(value = "/fwalk")
    public Double[] getFwalk(@RequestParam("sid") int sid) {
        return fitnessDao.queryFwalkBySid(sid);
    }

    @RequestMapping(value = "/fup")
    public Double[] getFup(@RequestParam("sid") int sid) {
        return fitnessDao.queryFupBySid(sid);
    }

    @RequestMapping(value = "/fahead")
    public Double[] getFahead(@RequestParam("sid") int sid) {
        return fitnessDao.queryFaheadBySid(sid);
    }
}
