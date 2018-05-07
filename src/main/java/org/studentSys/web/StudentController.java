package org.studentSys.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.studentSys.dao.StudentDao;
import org.studentSys.entity.Student;
import org.studentSys.service.StudentService;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by HuiJa on 2018/4/26.
 */
@Controller
public class StudentController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentDao studentDao;

    /**
     * 1.登录页显示
     *
     * @return
     */
    @RequestMapping(value = "/student")
    public String index() {
        return "/index/student_login";//index/student_login.jsp,这个根据前置后置设定来查找
    }

    /**
     * 2.登录执行
     *
     * @param sid
     * @param spasswd
     * @return 成功则进入主页
     */
    @RequestMapping(value = "/student/login-exection")
    public String studentLoginExcution(@RequestParam("sid") int sid,
                                       @RequestParam("spasswd") String spasswd,
                                       HttpSession session, Map<String, Object> requestMap) {
        String view = "/index/student_login";//显示登录页
        int result = studentService.studentLogin(sid, spasswd);
        if (result == 0) {
            //登录成功,记录登录信息
            Student student = studentDao.queryStudent(sid);
            session.setAttribute("student", student);
            requestMap.put("student", student);
            view="redirect:/student/index-show";//重定向是requestMapping,其余都是返回jsp
        } else {
            requestMap.put("LoginError", "1");
        }
        return view;
    }

    /**
     * 3.退出登录
     *
     * @param session1
     * @return 登录页面
     */
    @RequestMapping(value = "/student/exit")
    public String exit(HttpSession session1) {
        session1.removeAttribute("student");
        return "/index/student_login";
    }

    /**
     * 4.登录成功,显示主页
     * @return
     */
    @RequestMapping(value = "/student/index-show")
    public String indexShow(Map<String, Object> requestMap, HttpSession session) {
        requestMap.put("student",(Student)session.getAttribute("student"));//主页显示用户信息用
        String view="/index/index_show";
        return view;
    }
}
