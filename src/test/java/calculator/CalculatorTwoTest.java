package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/*
 Kalkulator powinien wylizać sinus kąta
 */
class CalculatorTwoTest {

    @Test
    public void shouldReturnZeroSixFor3And5() {
        // given
        CalculatorSinus calculatorSinus = new CalculatorSinus();
        // when
        float result = calculatorSinus.sinus(3, 5);
        // then
        assertEquals(0.6, result, 0.0001);
    }

    //Przeciwprostokątna musi być dłuższa niż przyprostokątna
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenHypotenuseIsShorterThanCathetus() {
        // given
        CalculatorSinus calculatorSinus = new CalculatorSinus();
        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> calculatorSinus.sinus(5, 3)
        );
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenHypotenuseOrCathetusLessThanZero() {
        // given
        CalculatorSinus calculatorSinus = new CalculatorSinus();
        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> calculatorSinus.sinus(-5, 3));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenEqualToZero() {
        // given
        CalculatorSinus calculatorSinus = new CalculatorSinus();
        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> calculatorSinus.sinus(0, 0));
    }

}