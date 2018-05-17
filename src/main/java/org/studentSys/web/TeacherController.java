package org.studentSys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.studentSys.dao.TeacherDao;
import org.studentSys.service.TeacherService;

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
}
