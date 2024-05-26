package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

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

    //TODO add the rest of the methods
}
