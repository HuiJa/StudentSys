package org.studentSys.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.studentSys.dao.StudentDao;
import org.studentSys.dao.TeacherDao;
import org.studentSys.entity.Student;
import org.studentSys.entity.Teacher;
import org.studentSys.service.StudentService;
import org.studentSys.service.TeacherService;
import org.studentSys.util.EncryptionUtil;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by HuiJa on 2018/4/26.
 */
@Controller
public class LoginController {
    //private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TeacherDao teacherDao;

    /**
     * 0.显示介绍主页
     *
     * @return
     */
    @RequestMapping(value = "/Introduction")
    public String introdution(HttpSession session, Map<String, Object> requestMap) {
        Student student = (Student) session.getAttribute("student");
        if (student != null) {
            requestMap.put("student", student);
        } else requestMap.put("teacher", "hello");
        //因为这个页面不需要显示用户信息,只需要判断登录信息,从简了
        return "/index/studentSys_index";
    }

    /**
     * 1.登录页显示
     *
     * @return
     */
    @RequestMapping(value = "/login")
    public String index() {
        return "/index/login";//index/login.jsp,这个根据前置后置设定来查找
    }

    /**
     * 2.登录执行
     *
     * @param id
     * @param passwd
     * @param kind
     * @param session
     * @param requestMap
     * @return 成功则进入主页
     */
    @RequestMapping(value = "/user/login-exection")
    public String LoginExcution(@RequestParam("id") int id,
                                @RequestParam("passwd") String passwd,
                                @RequestParam("kind") String kind,
                                HttpSession session, Map<String, Object> requestMap) {
        String view = "/index/login";//显示登录页
        int result = -1;//默认登录失败
        if ("stu".equals(kind)) {//学生登录
            result = studentService.studentLogin(id, passwd);
            if (result == 0) {
                //登录成功,记录登录信息
                Student student = studentDao.queryStudent(id);
                session.setAttribute("student", student);
                //requestMap.put("student", student);
                view = "redirect:/student/index-show";//重定向是requestMapping,其余都是返回jsp
            } else {
                requestMap.put("LoginError", "1");
            }
        } else if ("tea".equals(kind)) {//教师登录
            result = teacherService.teacherLogin(id, passwd);
            if (result == 0) {
                Teacher teacher = teacherDao.queryTeacher(id);
                session.setAttribute("teacher", teacher);
                //requestMap.put("teacher", teacher);
                view = "redirect:/teacher/index-show";
            } else {
                requestMap.put("LoginError", "1");
            }
        }
        return view;
    }

    /**
     * 3.修改密码按钮
     *
     * @return
     */
    @RequestMapping(value = "/passwd")
    public String passwd() {
        return "/index/passwd";//index/login.jsp,这个根据前置后置设定来查找
    }

    @RequestMapping(value = "/user/passd-execution")
    public String LoginExcution(@RequestParam("passwd1") String passwd1,
                                @RequestParam("passwd2") String passwd2,
                                HttpSession session, Map<String, Object> requestMap) {
        String view = "/index/passwd";//显示修改页
        Student student = (Student) session.getAttribute("student");
        if (student != null) {//学生登录
            int sid = student.getSid();
            if (passwd1.equals(passwd2)) {
                studentService.studentPasswd(sid, passwd1);
                view = "redirect:/login";
            } else {
                requestMap.put("PasswdError", "1");
            }
        } else {
            Teacher teacher = (Teacher) session.getAttribute("teacher");
            if (teacher != null) {
                int tid = teacher.getTid();
                if (passwd1.equals(passwd2)) {
                    teacherService.teacherPasswd(tid, passwd1);
                    view = "redirect:/login";
                } else {
                    requestMap.put("PasswdError", "1");
                }
            }
        }
        return view;
    }


}
