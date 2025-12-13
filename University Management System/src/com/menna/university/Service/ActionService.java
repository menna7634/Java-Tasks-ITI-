package com.menna.university.Service;

import com.menna.university.models.Course;
import com.menna.university.models.Student;
import com.menna.university.utils.InputUtils;

import java.util.Scanner;

public class ActionService {

    private final StudentService studentService;
    private final CourseService courseService;
    private final RegistrationService regService;

    public ActionService(StudentService studentService, CourseService courseService,
                         RegistrationService regService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.regService = regService;
    }

    public void addStudent(Scanner scanner) {
        int id = InputUtils.readInt(scanner, 1, Integer.MAX_VALUE, "Enter student ID: ");
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }
        try {
            Student s = new Student(id, name);
            studentService.addStudent(s);
            System.out.println("Student added.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addCourse(Scanner scanner) {
        int id = InputUtils.readInt(scanner, 1, Integer.MAX_VALUE, "Enter course ID: ");
        System.out.print("Enter course name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }
        int credits = InputUtils.readInt(scanner, 1, 50, "Enter credit hours: ");
        try {
            Course c = new Course(id, name, credits);
            courseService.addCourse(c);
            System.out.println("Course added.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void registerCourse(Scanner scanner) {
        int studentId = InputUtils.readInt(scanner, 1, Integer.MAX_VALUE, "Enter student ID: ");
        Student s = studentService.getStudentById(studentId);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        courseService.printAllCourses();
        int courseId = InputUtils.readInt(scanner, 1, Integer.MAX_VALUE, "Enter course ID to register: ");
        Course c = courseService.getCourseById(courseId);
        if (c == null) {
            System.out.println("Course not found.");
            return;
        }

        double grade = InputUtils.readDouble(scanner, 0, 100, "Enter grade (0-100): ");
        try {
            regService.registerCourse(s, c, grade);
            System.out.println("Course registered.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void printReport(Scanner scanner) {
        int studentId = InputUtils.readInt(scanner, 1, Integer.MAX_VALUE, "Enter student ID: ");
        Student s = studentService.getStudentById(studentId);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        regService.printStudentReport(s);
    }
}
