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

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.students = new ArrayList<>();
        this.finalScores = new ArrayList<>();
    }

    /**
     * check if the sum of the weight of all the assignments equals to 1
     * @return true if the sum of the weight is equal to 1 and false if not
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0;

        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }

        return sum == 1.0;
    }

    /**
     * registers a student. Add a student to the course's registered students list and add the course to the student's
     * registered courses list
     * @param student the input student
     * @return true if the student has been registered and false if the student had already been registered
     */
    public boolean registerStudent(Student student) {
        if (students.contains(student)) {
            System.out.printf("%s has already been registered.\n", student.getStudentName());
            return false;
        }

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }
        finalScores.add(null);
        students.add(student);
        student.getRegisteredCourses().add(this);
        System.out.printf("%s is successfully registered\n", student.getStudentName());
        return true;
    }

    /**
     * calculates the weighted average score for a student
     * @param student the input student
     * @return the weight average
     */
    public double calcStudentsAverage(Student student) {
        int idx = students.indexOf(student);

        double avg = 0;

        for (Assignment assignment : assignments) {
            avg += assignment.getScores().get(idx) * assignment.getWeight();
        }

        return avg;
    }

    /**
     * adds a new assignment to the course
     * @param assignmentName the assignment name
     * @param weight the weight of the assignment
     * @param maxScore the max score of the assignment
     * @return true if the assignment has been created and false if the assignment already existed
     */
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

    /**
     * generates a random scores for each assignment and student and calculate the final score of each student
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }

        for (int i = 0; i < students.size(); i++) {
            finalScores.set(i, calcStudentsAverage(students.get(i)));
        }
     }

    /**
     * displays the scores of a course in a table
     */
    public void displayScore() {

    }

    /**
     * converts a course to a simple string containing the course ID, course name, credits and department
     * @return the simplified course string
     */
    public String toSimplifiedString() {
        return String.format("Course ID: %s, Course Name: %s, Credits: %f, Department: %s\n",
                courseId, courseName, credits, department.getDepartmentName());
    }

    @Override
    public String toString() {
        String studentString = "";

        for (Student student : students) {
            studentString += student.toSimplifiedString();
        }

        return String.format("Course ID: %s, Course Name: %s, Credits: %f, Department: %s, Assignments: %s, Registered Students: %s",
                courseId, courseName, credits, department.getDepartmentName(), assignments, studentString);
    }
}
