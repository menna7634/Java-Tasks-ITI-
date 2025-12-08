package com.menna.university.Interfaces;

import com.menna.university.models.Student;
import com.menna.university.models.Course;

public interface Actions {
    void registerCourse(Student student, Course course, Double grade);
    void printStudentReport(Student student);
}
