package com.menna.university.Service;

import com.menna.university.models.Student;
import com.menna.university.utils.StudentValidator;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Cannot add null student.");
        }

        if (getStudentById(student.getStudentId()) != null) {
            throw new IllegalStateException("Student ID " + student.getStudentId() + " already exists.");
        }
        StudentValidator.validateStudent(student.getStudentId(), student.getStudentName());
        students.add(student);
    }
    public Student getStudentById(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid student ID: " + id);
        }

        for (Student s : students) {
            if (s.getStudentId().equals(id)) 
                return s;
        }
        return null; 
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("--- All Students ---");
        for (Student s : students) {
            System.out.println("ID: " + s.getStudentId() + " | Name: " + s.getStudentName());
        }
    }
}
