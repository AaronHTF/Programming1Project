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

    /**
     * registers a course. Add a course to the student's registered courses list and add the student to the course's
     * registered students list
     * @param course the input course
     * @return true if the course has been registered and false if the course had already been registered
     */
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

    /**
     * drops a course. Remove the course from the student's registered courses list and remove the student from the
     * course's registered students list
     * @param course the input course
     * @return true if the course had been dropped and false if the course wasn't registered
     */
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

    /**
     * converts a student into a simplified string containing only the student's ID and name and their department
     * @return the simplified student string
     */
    public String toSimplifiedString() {
        return String.format("Student ID: %s, Student Name: %s, Department: %s\n",
                studentId, studentName, department.getDepartmentName());
    }

    @Override
    public String toString() {
        String courseString = "";

        for (Course course : registeredCourses) {
            courseString += course.toSimplifiedString();
        }

        return String.format("Student ID: %s, Student Name: %s, Gender: %s, Address: %s, Department: %s, " +
                "Registered Courses: %s", studentId, studentName, gender, address, department, courseString);
    }
}
