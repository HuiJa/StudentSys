package org.huija.jpa.dao;

import org.huija.jpa.entity.Grade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GradeRepositoryTest {
    @Autowired
    private GradeRepository gradeRepository;

    @Test
    public void getAllGrade() {
        List<Grade> grades = gradeRepository.findAll();
        for (Grade grade : grades) {
            System.out.println(grade.toString());
        }
    }
}