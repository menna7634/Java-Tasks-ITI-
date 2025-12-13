package com.menna.university.Service;

import com.menna.university.models.Course;
import com.menna.university.utils.CourseValidator;
import java.util.ArrayList;
import java.util.List;

public class CourseService {

    private final List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Cannot add null course.");
        }

        if (getCourseById(course.getCourseId()) != null) {
            throw new IllegalStateException("Course ID " + course.getCourseId() + " already exists.");
        }
            CourseValidator.validate(course.getCourseId(), course.getCourseName(), course.getCreditHours());
        courses.add(course);

    }

    public Course getCourseById(int id) {
        for (Course c : courses) {
            if (c.getCourseId() == id)
                 return c;
        }
        return null; 
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }
    public void printAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("--- Available Courses ---");
        for (Course c : courses) {
            System.out.println("ID: " + c.getCourseId() + " | " + c.getCourseName() + " (" + c.getCreditHours() + " credits)");
        }
    }
}
