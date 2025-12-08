package com.menna.university.Service;

import com.menna.university.models.Student;
import com.menna.university.models.Course;
import com.menna.university.Interfaces.Actions;

public class RegistrationService implements Actions {

    @Override
    public void registerCourse(Student student, Course course, Double grade) {
        student.registerCourse(course, grade);
    }
    @Override
    public void printStudentReport(Student student) {
        student.printReport();
    }
}
