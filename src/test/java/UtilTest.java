import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.Util;

public class UtilTest {

    @Test
    public void testToTitleCase1() {
        String str = "aaa aaa";
        String expectedResult = "Aaa Aaa";
        String result = Util.toTitleCase(str);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase2() {
        String str = "AAA AAA";
        String expectedResult = "Aaa Aaa";
        String result = Util.toTitleCase(str);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase3() {
        String str = "aAA aAA";
        String expectedResult = "Aaa Aaa";
        String result = Util.toTitleCase(str);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase4() {
        String str = "";
        String expectedResult = "";
        String result = Util.toTitleCase(str);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase5() {
        String str = null;
        String expectedResult = null;
        String result = Util.toTitleCase(str);

        Assertions.assertEquals(expectedResult, result);
    }
}
