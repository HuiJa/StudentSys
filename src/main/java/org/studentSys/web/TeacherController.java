package org.studentSys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.studentSys.dao.ExtraDao;
import org.studentSys.dao.ReviewDao;
import org.studentSys.dao.StudentDao;
import org.studentSys.dao.TeacherDao;
import org.studentSys.entity.Review;
import org.studentSys.entity.Student;
import org.studentSys.entity.Teacher;
import org.studentSys.enums.EvaluatorEnums;
import org.studentSys.service.TeacherService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by HuiJa on 2018/5/17.
 */
@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private ReviewDao reviewDao;
    @Autowired
    private ExtraDao extraDao;


    /**
     * 1.老师登录显示，推出
     *
     * @param requestMap
     * @param session
     * @return
     */
    @RequestMapping(value = "/index-show")
    public String teaIndexShow(Map<String, Object> requestMap, HttpSession session) {
        String view = "/index/teacher_index";
        return view;
    }

    @RequestMapping(value = "/exit")
    public String teaExit(HttpSession session) {
        session.removeAttribute("teacher");
        return "/index/login";
    }

    /**
     * 2.导航栏
     *
     * @return
     */
    @RequestMapping(value = "/information")
    public String teaInfo(HttpSession session, Map<String, Object> requestMap) {
        requestMap.put("teacher", (Teacher) session.getAttribute("teacher"));
        return "/teacher/teacher_info";
    }

    /**
     * 3.侧边栏
     *
     * @return
     */
    @RequestMapping(value = "/stu-list")
    public String stuList(HttpSession session, Map<String, Object> requestMap) {
        Teacher teacher=(Teacher)session.getAttribute("teacher");
        ArrayList<Student> studentList = (ArrayList) teacherDao.queryByXid(teacher.getXid());
        requestMap.put("students", studentList);
        return "/teacher/stu_list";
    }

    /**
     *4.评价
     */
    @RequestMapping(value = "/comment")
    public String tacherReview(@RequestParam("comment") String comment, HttpSession session) {
        Student student=(Student) session.getAttribute("aim_stu");
        if ("".equals(comment) == false) {
            Review review = new Review(student.getSid(), EvaluatorEnums.教师, comment, new Date());
            reviewDao.insertReview(review);//这里需要空值判断
        }
        return "redirect:/teacher/dataShow?sid="+student.getSid();
    }

    /**
     *5.展示学生信息
     */
    @RequestMapping(value = "/dataShow")
    public String data(@RequestParam("sid") int sid, HttpSession session, Map<String, Object> requestMap) {
        //保持查询目标信息
        session.setAttribute("aim_stu",studentDao.queryStudent(sid));
        requestMap.put("studentExtras",extraDao.queryExtrasBySid(sid));
        return "/teacher/stu_data";
    }
}
