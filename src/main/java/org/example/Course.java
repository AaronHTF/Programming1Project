package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> students;
    private ArrayList<Double> finalScores;
    private static int nextId = 1;

    public boolean isAssignmentWeightValid() {
        double sum = 0;

        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }

        return sum == 1.0;
    }

    public boolean registerStudent(Student student) {
        if (students.contains(student)) {
            System.out.printf("%s has already been registered.\n", student.getStudentName());
            return false;
        }

        for (int i = 0; i < assignments.size(); i++) {
            assignments.get(i).getScores().add(null);
        }
        finalScores.add(null);
        students.add(student);
        student.getRegisteredCourses().add(this);
        System.out.printf("%s is successfully registered\n", student.getStudentName());
        return true;
    }

    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        for (Assignment assignment : assignments) {
            if (assignment.getAssignmentName().equals(assignmentName)) {
                System.out.printf("%s already exists.\n", assignmentName);
                return false;
            }
        }

        assignments.add(new Assignment(assignmentName, weight, maxScore));
        System.out.printf("%s had been created.\n", assignmentName);
        return true;
    }

    //TODO add the rest of the methods
}
