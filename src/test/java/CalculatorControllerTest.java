
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testSum() {
        double num1 = 10.0;
        double num2 = 5.0;
        assertEquals(15.0, num1 + num2);
    }

    @Test
    void testProduct() {
        double num1 = 10.0;
        double num2 = 5.0;
        assertEquals(50.0, num1 * num2);
    }

    @Test
    void testSubtraction() {
        double num1 = 10.0;
        double num2 = 5.0;
        assertEquals(5.0, num1 - num2);
    }

    @Test
    void testDivision() {
        double num1 = 10.0;
        double num2 = 5.0;
        assertEquals(2.0, num1 / num2);
    }

    @Test
    void testDivisionByZero() {
        double num1 = 10.0;
        double num2 = 0.0;
        assertTrue(Double.isInfinite(num1 / num2));
    }
}