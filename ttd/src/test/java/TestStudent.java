import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStudent {

    private Student studentA;

    @Before
    public void setUp() {
        studentA = new Student("Tom", "Anderson", 24, 8.76, 24, 9.87);
        //studentA = new Student("Tom", "Anderson", 24, 6.76, 24, 9.87);
    }

    //studentAisBetterThenStudentB
    @Test
    public void studentAisBetterThenStudentB() {

        Student studentB = new Student("Bill", "Smith", 23, 7.00, 23, 7.99);

        Assert.assertTrue(studentB.comparesWith(studentA));
    }

    //studentBisBetterThenStudentA
    @Test
    public void studentBisBetterThenStudentA() {

        Student studentB = new Student("Bill", "Smith", 23, 9.00, 24, 8.99);

        Assert.assertTrue(studentB.comparesWith(studentA));
    }

    //checkIfItIsTheSameStudent
    @Test
    public void checkIfTheSameStudent() {

        Student studentB = studentA;

        Assert.assertTrue(studentB.comparesWith(studentA));
    }

    //studentAHasBecomeBetterInTimeThanB
    @Test
    public void studentAHasBecomeBetterInTimeThanB() {

        Student studentB = new Student("Bill", "Smith", 23, 9.00, 24, 9.67);

        Assert.assertTrue(studentB.comparesWith(studentA));
    }

    //studentBHasBecomeBetterInTimeThanA
    @Test
    public void studentBHasBecomeBetterInTimeThanA() {

        Student studentB = new Student("Bill", "Smith", 23, 9.02, 24, 9.00);

        Assert.assertTrue(studentB.comparesWith(studentA));
    }

    //bothStudentsHaveBecomeBetterInTime
    @Test
    public void bothStudentsHaveBecomeBetterInTime() {

        Student studentB = new Student("Bill", "Smith", 23, 9.02, 24, 9.00);

        Assert.assertTrue(studentB.comparesWith(studentA));
    }

    //bothStudentsHaveNotBecomeBetterInTime
    @Test
    public void bothStudentsHaveNotBecomeBetterInTime() {

        Student studentB = new Student("Bill", "Smith", 23, 9.02, 24, 9.04);

        Assert.assertTrue(studentB.comparesWith(studentA));
    }

    @Test
    public void addTwoNumbersTest() {
        //Arrange
        int one = 3;
        int two = 5;

        //Act
        int result = 8;
        int result1 = studentA.addTwoNumbers(3, 5);
        //Assert
        Assert.assertEquals(result, result1);


    }
}
