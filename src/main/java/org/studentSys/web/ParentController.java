package org.studentSys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.studentSys.dao.ExtraDao;
import org.studentSys.dao.ParentDao;
import org.studentSys.dao.ReviewDao;
import org.studentSys.dao.StudentDao;
import org.studentSys.entity.Review;
import org.studentSys.entity.Student;
import org.studentSys.entity.Teacher;
import org.studentSys.enums.EvaluatorEnums;
import org.studentSys.service.ParentService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by HuiJa on 2018/5/31.
 */
@Controller
@RequestMapping(value = "/parent")
public class ParentController {
    @Autowired
    ParentDao parentDao;
    @Autowired
    ParentService parentService;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private ReviewDao reviewDao;
    @Autowired
    private ExtraDao extraDao;

    /**
     * 1.家长登录显示，推出
     *
     * @param requestMap
     * @param session
     * @return
     */
    @RequestMapping(value = "/index-show")
    public String parIndexShow(Map<String, Object> requestMap, HttpSession session) {
        String view = "/index/parent_index";
        return view;
    }

    @RequestMapping(value = "/exit")
    public String parExit(HttpSession session) {
        session.removeAttribute("parent");
        session.removeAttribute("child");
        return "/index/login";
    }

    /**
     * 2.导航栏
     *
     * @return
     */
    @RequestMapping(value = "/information")
    public String childInfo(HttpSession session, Map<String, Object> requestMap) {
        return "/parent/child_info";
    }

    @RequestMapping(value = "/teacher-info")
    public String teaInfo(HttpSession session, Map<String, Object> requestMap) {
        Student student = (Student) session.getAttribute("child");
        Teacher teacher = studentDao.queryTeacher(student.getXid());
        requestMap.put("teacherMessage", teacher);
        return "/parent/teacher_info";
    }

    /**
     * 3.侧边栏
     */
    @RequestMapping(value = "/grade")
    public String grade(HttpSession session, Map<String, Object> requestMap) {
        Student student = (Student) session.getAttribute("child");
        requestMap.put("studentExtras", extraDao.queryExtrasBySid(student.getSid()));
        return "/parent/grade";
    }

    /**
     * 4.评价
     */
    @RequestMapping(value = "/child_comment")
    public String addReview(@RequestParam("comment") String comment, HttpSession session) {
        Student student = (Student) session.getAttribute("child");
        if ("".equals(comment) == false) {
            Review review = new Review(student.getSid(), EvaluatorEnums.家长, comment, new Date());
            reviewDao.insertReview(review);//这里需要空值判断
        }
        return "redirect:/parent/grade";
    }
    @RequestMapping(value = "/comment")
    public String parentReview(@RequestParam("comment") String comment, HttpSession session) {
        Student student = (Student) session.getAttribute("aim_stu");
        if ("".equals(comment) == false) {
            Review review = new Review(student.getSid(), EvaluatorEnums.家长, comment, new Date());
            reviewDao.insertReview(review);//这里需要空值判断
        }
        return "redirect:/parent/dataShow?sid=" + student.getSid();
    }

    /**
     * 5.展示学生信息
     */
    @RequestMapping(value = "/dataShow")
    public String data(@RequestParam("sid") int sid, HttpSession session, Map<String, Object> requestMap) {
        //保持查询目标信息
        session.setAttribute("aim_stu", studentDao.queryStudent(sid));
        requestMap.put("studentExtras", extraDao.queryExtrasBySid(sid));
        return "/parent/stu_data";
    }

    /**
     * 6.搜索目标
     */
    @RequestMapping(value = "/search")
    public String search(@RequestParam("aim") String aim, Map<String, Object> requestMap) {
        ArrayList<Student> studentList = (ArrayList) studentDao.queryByLike(aim);
        requestMap.put("students", studentList);
        return "/parent/stu_list";
        //返回student的stu_list主要是因为学生老师的导航栏侧边栏不一样,不然可以直接合为一个
    }
}
