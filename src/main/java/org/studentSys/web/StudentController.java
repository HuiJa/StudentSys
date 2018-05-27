package org.studentSys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.studentSys.dao.StudentDao;
import org.studentSys.entity.Student;
import org.studentSys.service.StudentService;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by HuiJa on 2018/5/17.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentDao studentDao;

    /**
     * 1.学生登录显示，退出
     *
     * @return
     */
    @RequestMapping(value = "/index-show")
    public String stuIndexShow(Map<String, Object> requestMap, HttpSession session) {
        requestMap.put("student", (Student) session.getAttribute("student"));//主页显示用户信息用
        String view = "/index/student_index";
        return view;
    }

    @RequestMapping(value = "/exit")
    public String stuExit(HttpSession session) {
        session.removeAttribute("student");
        return "/index/login";
    }

    /**
     * 2.导航栏
     *
     * @return
     */
    @RequestMapping(value = "/information")
    public String stuInfo(HttpSession session, Map<String, Object> requestMap) {
        requestMap.put("student", (Student) session.getAttribute("student"));
        return "/student/student_info";
    }

    @RequestMapping(value = "/teacher-info")
    public String teaInfo(HttpSession session, Map<String, Object> requestMap) {
        Student student = (Student) session.getAttribute("student");
        //TODO 根据学号查询老师信息
        return "/teacher/teacher_info";
    }

    /**
     * 3.侧边栏
     */
    @RequestMapping(value = "/grade")
    public String grade(HttpSession session, Map<String, Object> requestMap) {
        return "/student/grade";
    }

    @RequestMapping(value = "/fitness")
    public String fitness(HttpSession session, Map<String, Object> requestMap) {
        return "/student/fitness";
    }

    @RequestMapping(value = "/reviews")
    public String reviews(HttpSession session, Map<String, Object> requestMap) {
        Student student = (Student) session.getAttribute("student");
        requestMap.put("teacherReviews", studentService.teacherReview(student));
        requestMap.put("studentReviews", studentService.studentReview(student));
        requestMap.put("ownReviews", studentService.ownReview(student));
        return "/student/reviews";
    }

    @RequestMapping(value = "/own")
    public String own(HttpSession session, Map<String, Object> requestMap) {
        return "/student/own";
    }
}
