package org.studentSys;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @RequestMapping(value = "/hello")
    public String helloSpring(){
        return "Hello SpringBoot!!!";
    }
}
