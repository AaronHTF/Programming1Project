package org.example;

import java.util.ArrayList;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAverage;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    public void calcAssignmentAvg() {
        int sum = 0;

        for (int score : scores) {
            sum += score;
        }

        assignmentAverage = (double) sum / scores.size();
    }

    public void generateRandomScore() {
        //TODO finish method body
    }

    @Override
    public String toString() {
        return String.format("Assignment ID: %s, Assignment Name: %s, Weight: %f, maxScore: %d",
                assignmentId, assignmentName, weight, maxScore);
    }

    //TODO add the rest of the methods
}
