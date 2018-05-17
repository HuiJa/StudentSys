package org.studentSys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.studentSys.dao.StudentDao;
import org.studentSys.service.StudentService;

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

}
