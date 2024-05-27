package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@EqualsAndHashCode
@Getter
@Setter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAverage;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight, int maxScore) {
        this.assignmentId = "" + nextId++;
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.maxScore = maxScore;
        calcAssignmentAvg();
        this.scores = new ArrayList<>();
    }

    /**
     * calculates the average score for the assignment
     */
    public void calcAssignmentAvg() {
        int sum = 0;

        for (int score : scores) {
            sum += score;
        }

        assignmentAverage = (double) sum / scores.size();
    }

    /**
     * generates a random score for each student for this assignment
     */
    public void generateRandomScore() {
        Random rand = new Random();

        for (int i = 0; i < scores.size(); i++) {
            switch (rand.nextInt(0, 11)) {
                case 0 -> scores.set(i, rand.nextInt(0, 60));
                case 1, 2 -> scores.set(i, rand.nextInt(60, 70));
                case 3, 4 -> scores.set(i, rand.nextInt(70, 80));
                case 5, 6, 7, 8 -> scores.set(i, rand.nextInt(80, 90));
                case 9, 10 -> scores.set(i, rand.nextInt(90, 100));
            }
        }

        calcAssignmentAvg();
    }

    @Override
    public String toString() {
        return String.format("Assignment ID: %s, Assignment Name: %s, Weight: %f, maxScore: %d",
                assignmentId, assignmentName, weight, maxScore);
    }

    public ArrayList<Integer> getScores() {
        calcAssignmentAvg();
        return scores;
    }
}
