package org.studentSys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.studentSys.dao.FitnessDao;
import org.studentSys.dao.StudentDao;
import org.studentSys.dto.StudentGrade;
import org.studentSys.entity.Fitness;

import java.util.ArrayList;

/**
 * Created by HuiJa on 2018/5/27.
 */
@Controller
@RequestMapping(value = "/api")
public class DataApi {
    @Autowired
    StudentDao studentDao;
    @Autowired
    FitnessDao fitnessDao;
    //成绩相关
    @RequestMapping(value = "/course")
    @ResponseBody
    public String[] getCourse(@RequestParam("sid") int sid, @RequestParam("cyear") int cyear) {
        ArrayList<StudentGrade> studentGrades = (ArrayList) studentDao.queryGrades(sid, cyear);
        String[] s = new String[studentGrades.size()];
        int i = 0;
        for (StudentGrade studentGrade : studentGrades) {
            s[i] = studentGrade.getCname();
            i++;
        }
        return s;
    }

    @RequestMapping(value = "/grade")
    @ResponseBody
    public int[] getGrade(@RequestParam("sid") int sid, @RequestParam("cyear") int cyear) {
        ArrayList<StudentGrade> studentGrades = (ArrayList) studentDao.queryGrades(sid, cyear);
        int[] ii = new int[studentGrades.size()];
        int i = 0;
        for (StudentGrade studentGrade : studentGrades) {
            ii[i] = studentGrade.getGresult();
            i++;
        }
        return ii;
    }
    //体测相关
    @RequestMapping(value = "/fheig")
    @ResponseBody
    public Double[] getFheig(@RequestParam("sid") int sid) {
        return fitnessDao.queryFheigBySid(sid);
    }
    @RequestMapping(value = "/fweig")
    @ResponseBody
    public Double[] getFweig(@RequestParam("sid") int sid) {
        return fitnessDao.queryFweigBySid(sid);
    }
    @RequestMapping(value = "/frun")
    @ResponseBody
    public Double[] getFrun(@RequestParam("sid") int sid) {
        return fitnessDao.queryFrunBySid(sid);
    }
    @RequestMapping(value = "/fjump")
    @ResponseBody
    public Double[] getFjump(@RequestParam("sid") int sid) {
        return fitnessDao.queryFjumpBySid(sid);
    }
    @RequestMapping(value = "/fwalk")
    @ResponseBody
    public Double[] getFwalk(@RequestParam("sid") int sid) {
        return fitnessDao.queryFwalkBySid(sid);
    }
    @RequestMapping(value = "/fup")
    @ResponseBody
    public Double[] getFup(@RequestParam("sid") int sid) {
        return fitnessDao.queryFupBySid(sid);
    }
    @RequestMapping(value = "/fahead")
    @ResponseBody
    public Double[] getFahead(@RequestParam("sid") int sid) {
        return fitnessDao.queryFaheadBySid(sid);
    }
}
