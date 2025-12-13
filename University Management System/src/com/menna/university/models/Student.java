package com.menna.university.models;
import com.menna.university.utils.StudentValidator;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private final Integer studentId;
    private final String studentName;
    private final List<CourseRegistration> registrations;

    public Student(Integer studentId, String studentName) {
        StudentValidator.validateStudent(studentId, studentName);

        this.studentId = studentId;
        this.studentName = studentName;
        this.registrations = new ArrayList<>();
    }

   public void registerCourse(Course course, Double grade) {
    StudentValidator.validateCourse(course);
    StudentValidator.validateGrade(grade);
    StudentValidator.validateDuplicateRegistration(this.registrations, this.studentId, course);
    this.registrations.add(new CourseRegistration(course, grade));
}


    public void printReport() {
        StringBuilder report = new StringBuilder();
        report.append("--- Student Report ---\n");
        report.append("ID: ").append(studentId).append("\n");
        report.append("Name: ").append(studentName).append("\n");
        report.append("----------------------\n");

        if (registrations.isEmpty()) {
            report.append(studentName).append(" is not registered in any courses yet.\n");
        } else {
            report.append("Course Enrollments:\n");
            for (CourseRegistration reg : registrations) {
                report.append("  - ").append(reg).append("\n");
            }
        }

        System.out.print(report.toString());
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<CourseRegistration> getRegistrations() {
        return List.copyOf(registrations);
    }

    public static class CourseRegistration {
        private final Course course;
        private final Double grade;

        public CourseRegistration(Course course, Double grade) {
             StudentValidator.validateCourse(course);
             StudentValidator.validateGrade(grade);
            this.course = course;
            this.grade = grade;
        }

        public Course getCourse() {
            return course;
        }

        public Double getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return course.getCourseName() + " (" + course.getCreditHours() + " credits)" +
                   ": Grade=" + (grade != null ? String.format("%.2f", grade) : "N/A");
        }
    }
}
