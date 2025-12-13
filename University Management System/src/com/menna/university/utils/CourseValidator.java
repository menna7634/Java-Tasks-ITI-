package com.menna.university.utils;

public class CourseValidator {

    public static void validate(int courseId, String courseName, int creditHours) {
        if (courseId <= 0){
            throw new IllegalArgumentException("Course ID must be positive.");
        }
        if (courseName == null || courseName.trim().isEmpty()){
            throw new IllegalArgumentException("Course name cannot be empty.");
        }

        if (creditHours <= 0){
            throw new IllegalArgumentException("Credit hours must be positive.");
        }
    }
}
