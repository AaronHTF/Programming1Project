import org.example.Assignment;
import org.example.Course;
import org.example.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssignmentTest {

    @Test
    public void testCalcAssignmentAvg() {
        Assignment assignment = new Assignment("assignment 1", 0.15, 100);

        double expectedResult1 = 0;
        double expectedResult2 = 100;
        double expectedResult3 = 75;

        double result1 = assignment.getAssignmentAverage();
        assignment.getScores().add(100);
        double result2 = assignment.getAssignmentAverage();
        assignment.getScores().add(50);
        double result3 = assignment.getAssignmentAverage();

        Assertions.assertEquals(expectedResult1, result1);
        Assertions.assertEquals(expectedResult2, result2);
        Assertions.assertEquals(expectedResult3, result3);
    }

    @Test
    public void testIsAssignmentWeightValid1() {
        Department department = new Department("Department");
        Course course = new Course("Course", 2, department);

        course.addAssignment("Assignment 1", 0.25, 100);
        course.addAssignment("Assignment 2", 0.25, 100);
        course.addAssignment("Assignment 3", 0.25, 100);
        course.addAssignment("Assignment 4", 0.25, 100);

        boolean expectedResult = true;
        boolean result = course.isAssignmentWeightValid();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAssignmentWeightValid2() {
        Department department = new Department("Department");
        Course course = new Course("Course", 2, department);

        course.addAssignment("Assignment 1", 0.20, 100);
        course.addAssignment("Assignment 2", 0.20, 100);
        course.addAssignment("Assignment 3", 0.20, 100);
        course.addAssignment("Assignment 4", 0.20, 100);

        boolean expectedResult = false;
        boolean result = course.isAssignmentWeightValid();

        Assertions.assertEquals(expectedResult, result);
    }
}
