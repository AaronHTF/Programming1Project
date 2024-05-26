package org.example;

import java.util.ArrayList;
import java.util.function.DoubleFunction;

public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            System.out.printf("%s has already been registered.\n", course.getName());
            return false;
        }
        registeredCourses.add(course);
        course.getStudents().add(this);
        System.out.printf("%s is successfully registered.\n", course.getName());
        return true;
    }

    public boolean dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.getStudents().remove(this);
            System.out.printf("%s is successfully dropped.\n", course.getName());
            return true;
        }
        System.out.printf("%s is not registered.\n", course.getName());
        return false;
    }
}
