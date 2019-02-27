package org.studentSys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.studentSys.dao.FitnessDao;
import org.studentSys.dao.StudentDao;
import org.studentSys.dto.StudentGrade;

import java.util.ArrayList;

/**
 * Created by HuiJa on 2018/5/27.
 */
@RestController
@RequestMapping(value = "/api")
public class DataApi {
    @Autowired
    StudentDao studentDao;
    @Autowired
    FitnessDao fitnessDao;

    //成绩相关
    @RequestMapping(value = "/course")
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
