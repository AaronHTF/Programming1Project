package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            System.out.printf("%s has already been registered.\n", course.getCourseName());
            return false;
        }
        registeredCourses.add(course);
        course.getStudents().add(this);
        System.out.printf("%s is successfully registered.\n", course.getCourseName());
        return true;
    }

    public boolean dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.getStudents().remove(this);
            System.out.printf("%s is successfully dropped.\n", course.getCourseName());
            return true;
        }
        System.out.printf("%s is not registered.\n", course.getCourseName());
        return false;
    }

    //TODO add the rest of the methods
}
