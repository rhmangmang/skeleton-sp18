import static org.junit.Assert.*;
import org.junit.Test;
public class ArithmeticTest {
    @Test
    public void testProduct() {
        /* assertEquals for comparison of ints takes two arguments:assertEquals(expected, actual).
        if it is false, then the assertion will be false, and this test will fail.*/
        assertEquals(30, Arithmetic.product(5, 6));
        assertEquals(-30, Arithmetic.product(5, -6));
        assertEquals(0, Arithmetic.product(0, -6));
    }
    @Test
    public void testSum() {
        assertEquals(11, Arithmetic.sum(5, 6));
        assertEquals(-1111, Arithmetic.sum(5, -6));
        assertEquals(-6, Arithmetic.sum(0, -6));
        assertEquals(0, Arithmetic.sum(6, -6));
    }
    /* Run the unit tests in this file. */
    public static void main(String... args) {
        jh61b.junit.TestRunner.runTests("any", ArithmeticTest.class); //mode参数还可以修改为failed
    }
}
