package javafortesters;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class MyFirstTest {
    @Test
    public void plusTwoNumber()
    {
        int sum = 2+2;
        assertEquals("2+2=4", 4, sum);

    }
}
