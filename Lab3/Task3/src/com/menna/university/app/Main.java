package com.menna.university.app;

import com.menna.university.Service.*;
import com.menna.university.utils.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        RegistrationService regService = new RegistrationService();
        ActionService actions = new ActionService(studentService, courseService, regService);

        boolean running = true;

        while (running) {
            System.out.println("\n=== University System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Register Student for Course");
            System.out.println("4. Print Student Report");
            System.out.println("5. List All Students");
            System.out.println("6. List All Courses");
            System.out.println("7. Exit");

            int choice = InputUtils.readInt(scanner, 1, 7, "Choose an option: ");

          switch (choice) {
    case 1:
        actions.addStudent(scanner);
        break;

    case 2:
        actions.addCourse(scanner);
        break;

    case 3:
        actions.registerCourse(scanner);
        break;
    case 4:
        actions.printReport(scanner);
        break;

    case 5:
        studentService.printAllStudents();
        break;

    case 6:
        courseService.printAllCourses();
        break;

    case 7:
        running = false;
        break;

    default:
        System.out.println("Invalid choice. Please try again.");
}

        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}
