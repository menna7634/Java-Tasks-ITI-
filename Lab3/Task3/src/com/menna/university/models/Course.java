package com.menna.university.models;
import  com.menna.university.utils.CourseValidator;
public class Course {

    private final int courseId;
    private final String courseName;
    private final int creditHours;

    public Course(int courseId, String courseName, int creditHours) {
        CourseValidator.validate(courseId, courseName, creditHours);
        this.courseId = courseId;
        this.courseName = courseName;
        this.creditHours = creditHours;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", creditHours=" + creditHours +
                '}';
    }
}
