import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CourseTest {

    @Test
    public void testCalcStudentAverage() {
        Address address = new Address(1111, "street", "city", "province", "a1b2c3", "country");
        Department department = new Department("Department");
        Student student = new Student("Name", Gender.MALE, address, department);
        Course course = new Course("Course", 2, department);

        student.registerCourse(course);
        course.addAssignment("Assignment", 0.2, 100);
        course.generateScores();

        double result = course.getFinalScores().get(0);
        double expectedResult = course.calcStudentsAverage(student);

        Assertions.assertEquals(expectedResult, result);
    }
}
