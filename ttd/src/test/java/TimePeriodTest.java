import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class TimePeriodTest {

    private  TimePeriod timePeriodA;
    SimpleDateFormat dateFormat;
    TimePeriod timePeriodB;

    @Before
    public void setUp() throws ParseException {
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        timePeriodA = new TimePeriod(dateFormat.parse("01/01/2019"), dateFormat.parse("30/04/2019"));
    }

    @Test
    public void testAcontainsB() throws ParseException {

        timePeriodB = new TimePeriod(dateFormat.parse("01/02/2019"), dateFormat.parse("28/02/2019"));
        Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));

    }

    @Test
    public void testBcontainsA() throws ParseException {

        timePeriodB = new TimePeriod(dateFormat.parse("01/01/2018"), dateFormat.parse("30/04/2020"));
        Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));

    }

    @Test
    public void testBinteractA() throws ParseException {
        timePeriodB = new TimePeriod(dateFormat.parse("01/02/2018"), dateFormat.parse("01/05/2019"));
        Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
    }

    @Test
    public void testAinteractB() throws ParseException {
        timePeriodB = new TimePeriod(dateFormat.parse("01/02/2019"),dateFormat.parse("01/06/2019"));
        Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
    }


    @Test
    public void testAequalsB() throws ParseException {
        timePeriodB = timePeriodA;
        Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
    }

    @Test
    public void testAendEqualToBstart() throws ParseException {
        timePeriodB =  new TimePeriod(dateFormat.parse("30/04/2019"),dateFormat.parse("01/06/2019"));
        Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
    }


    @Test
    public void testBendEqualToAstart() throws ParseException {
        timePeriodB = new TimePeriod(dateFormat.parse("01/06/2018"), dateFormat.parse("01/01/2019"));
        Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
    }

    @Test
    public void testAnotOverlapB() throws ParseException {
        timePeriodB = new TimePeriod(dateFormat.parse("01/01/2018"), dateFormat.parse("30/04/2018"));
        Assert.assertFalse(timePeriodA.overlapsWith(timePeriodB));

    }



}
