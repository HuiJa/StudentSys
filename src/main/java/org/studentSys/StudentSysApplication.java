package org.studentSys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StudentSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentSysApplication.class, args);
    }

}
