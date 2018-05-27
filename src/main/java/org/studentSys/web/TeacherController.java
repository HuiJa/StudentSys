package org.studentSys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.studentSys.dao.StudentDao;
import org.studentSys.dao.TeacherDao;
import org.studentSys.entity.Student;
import org.studentSys.entity.Teacher;
import org.studentSys.service.TeacherService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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


    /**
     * 1.老师登录显示，推出
     *
     * @param requestMap
     * @param session
     * @return
     */
    @RequestMapping(value = "/index-show")
    public String teaIndexShow(Map<String, Object> requestMap, HttpSession session) {
        requestMap.put("teacher", (Teacher) session.getAttribute("teacher"));//主页显示用户信息用
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

    @RequestMapping(value = "/own")
    public String own(HttpSession session, Map<String, Object> requestMap) {
        return "/teacher/own";
    }

    /**
     *4.评价
     */
    @RequestMapping(value = "/comment")
    public String studentReview(@RequestParam("review") String comment, HttpSession session) {
        return null;
    }
}
