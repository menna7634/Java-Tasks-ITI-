package com.menna.university.utils;
import com.menna.university.models.Course;
import com.menna.university.models.Student.CourseRegistration;

import java.util.List;

public class StudentValidator {

    private static final double MAX_GRADE = 100.0;

    public static void validateStudent(Integer studentId, String studentName) {
        if (studentId == null || studentId <= 0) {
            throw new IllegalArgumentException("Student ID must be a positive integer.");
        }
        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be null or empty.");
        }
    }

    public static void validateRegistration(List<CourseRegistration> registrations, Integer studentId, Course course, Double grade) {
        validateCourse(course);
        validateGrade(grade);
        validateDuplicateRegistration(registrations, studentId, course);

    }

    public static void validateCourse(Course course) {
                if (course == null)
            throw new IllegalArgumentException("Course object cannot be null.");

        CourseValidator.validate(course.getCourseId(), course.getCourseName(), course.getCreditHours());
    }

    public static void validateGrade(Double grade) {
        if (grade != null && (grade < 0.0 || grade > MAX_GRADE)) {
            throw new IllegalArgumentException("Grade must be between 0 and " + MAX_GRADE);
        }
    }

public static void validateDuplicateRegistration(List<CourseRegistration> registrations, Integer studentId, Course course) {
    for (CourseRegistration r : registrations) {
        if (r.getCourse().getCourseId() == course.getCourseId()) {
            throw new IllegalStateException(
                "Student with ID " + studentId + " is already registered for course: " + course.getCourseName()
            );
        }
    }
}


}
