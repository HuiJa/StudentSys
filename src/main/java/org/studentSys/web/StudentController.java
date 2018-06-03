package org.studentSys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.studentSys.dao.ExtraDao;
import org.studentSys.dao.ReviewDao;
import org.studentSys.dao.StudentDao;
import org.studentSys.entity.Review;
import org.studentSys.entity.Student;
import org.studentSys.entity.Teacher;
import org.studentSys.enums.EvaluatorEnums;
import org.studentSys.service.StudentService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private ReviewDao reviewDao;
    @Autowired
    private ExtraDao extraDao;

    /**
     * 1.学生登录显示，退出
     *
     * @return
     */
    @RequestMapping(value = "/index-show")
    public String stuIndexShow(Map<String, Object> requestMap, HttpSession session) {
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
        Teacher teacher = studentDao.queryTeacher(student.getXid());
        requestMap.put("teacherMessage", teacher);
        return "/student/teacher_info";
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
        requestMap.put("teacherReviews", (ArrayList) studentService.teacherReview(student));
        requestMap.put("studentReviews", (ArrayList) studentService.studentReview(student));
        requestMap.put("parentReviews", (ArrayList) studentService.parentReview(student));
        return "/student/reviews";
    }

    @RequestMapping(value = "/own")
    public String own(HttpSession session, Map<String, Object> requestMap) {
        Student student = (Student) session.getAttribute("student");
        requestMap.put("ownReviews", (ArrayList) studentService.ownReview(student));
        requestMap.put("ownExtras",extraDao.queryExtrasBySid(student.getSid()));
        return "/student/own";
    }

    /**
     * 4.删除添加评论
     */
    @RequestMapping(value = "/deleteReview")
    public String removeReview(@RequestParam("rid") int rid) {
        reviewDao.deleteReview(rid);
        return "redirect:/student/own";
    }

    @RequestMapping(value = "/addReview")
    public String addReview(@RequestParam("comment") String comment, HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        if ("".equals(comment) == false) {
            Review review = new Review(student.getSid(), EvaluatorEnums.自己, comment, new Date());
            reviewDao.insertReview(review);
        }
        return "redirect:/student/own";
    }

    @RequestMapping(value = "/comment")
    public String studentReview(@RequestParam("comment") String comment, HttpSession session) {
        Student student=(Student) session.getAttribute("aim_stu");
        if ("".equals(comment) == false) {
            Review review = new Review(student.getSid(), EvaluatorEnums.同学, comment, new Date());
            reviewDao.insertReview(review);
        }
        return "redirect:/student/dataShow?sid="+student.getSid();
    }

    /**
     * 5.搜索目标
     */
    @RequestMapping(value = "/search")
    public String search(@RequestParam("aim") String aim, Map<String, Object> requestMap) {
        ArrayList<Student> studentList = (ArrayList) studentDao.queryByLike(aim);
        requestMap.put("students", studentList);
        return "/student/stu_list";
        //返回student的stu_list主要是因为学生老师的导航栏侧边栏不一样,不然可以直接合为一个
    }

    @RequestMapping(value = "/dataShow")
    public String data(@RequestParam("sid") int sid, HttpSession session,Map<String, Object> requestMap) {
        //保持查询目标信息
        session.setAttribute("aim_stu",studentDao.queryStudent(sid));
        requestMap.put("studentExtras",extraDao.queryExtrasBySid(sid));
        return "/student/stu_data";
        //返回student的stu_list主要是因为学生老师的导航栏侧边栏不一样,不然可以直接合为一个
    }

}
