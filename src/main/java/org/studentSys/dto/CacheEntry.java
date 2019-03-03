package org.studentSys.dto;

import java.util.ArrayList;

public class CacheEntry {
    private ArrayList<StudentGrade> studentGrades;
    public CacheEntry(ArrayList<StudentGrade> studentGrades){
        this.studentGrades=studentGrades;
    }
    public ArrayList<StudentGrade> getstudentGrades(){
        return studentGrades;
    }

    public void setstudentGrades(ArrayList<StudentGrade> getstudentGrades) {
        this.studentGrades = studentGrades;
    }
}
