package by.teachmeskills.studens;

import by.teachmeskills.model.Sex;
import by.teachmeskills.model.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentTests {
    private static Student student1;
    private static Student student2;
    private static Student student3;

    private static List<Student> actual;
    private static List<Student> actualBySex;

    @BeforeAll
    public static void setUp() {
        student1 = new Student("Ivan", 17, Sex.MALE);
        student2 = new Student("Anna", 19, Sex.FEMALE);
        student3 = new Student("Polina", 18, Sex.FEMALE);

        actual = new ArrayList<>();
        actual.add(student1);
        actual.add(student2);
        actual.add(student3);

        actualBySex = new ArrayList<>();
        actualBySex.add(student1);
    }

    @Test
    public void checkAllStudentsReturned() {
        List<Student> expected = Student.getAllStudents();
        assertEquals(expected, actual);
    }

    @Test
    public void checkAllStudentsReturned_NotNull() {
        List<Student> expected = Student.getAllStudents();
        assertNotNull(expected);
    }

    @Test
    public void getAllUsers_MALE() {
        List<Student> expected = Student.getAllStudentsBySex(Sex.MALE);
        assertEquals(expected, actualBySex);
    }


    @Test
    public void checkStudentsCount_MALE() {
        int expectedSize = Student.getStudentsCountWithSex(Sex.MALE);
        assertEquals(expectedSize, 1);
    }

    @Test
    public void checkStudentsCount() {
        int expectedSize = Student.getStudentsCount();
        assertEquals(expectedSize, 3);
    }

    @Test
    public void checkAllStudentsSumAge() {
        int expectedSumAge = Student.getSumOfAllStudentsAge();
        assertEquals(expectedSumAge, 54);
    }

    @Test
    public void checkAllStudentsSumAgeBySex_MALE() {
        int expectedSumAge = Student.getSumOfAllStudentsAgeBySex(Sex.MALE);
        assertEquals(expectedSumAge, 17);
    }

    @Test
    public void checkAllStudentsAverageAge() {
        int expectedAverageAge = Student.getAverageAgeOfAllStudents();
        assertEquals(expectedAverageAge, 18);
    }

    @Test
    public void checkAllStudentsAverageAgeBySex_FEMALE() {
        int expectedAverageAge = Student.getAverageOfAllStudentsBySex(Sex.FEMALE);
        assertEquals(expectedAverageAge, 18);
    }


}
