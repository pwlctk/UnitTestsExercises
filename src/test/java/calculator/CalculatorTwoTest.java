package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/*
 Kalkulator powinien wylizać sinus kąta
 */
class CalculatorTwoTest {

    @Test
    void shouldReturnZeroSixFor3And5() {
        // given
        CalculatorSinus calculatorSinus = new CalculatorSinus();
        // when
        float result = calculatorSinus.sinus(3, 5);
        // then
        assertEquals(0.6, result, 0.0001);
    }

    //Przeciwprostokątna musi być dłuższa niż przyprostokątna
    @Test
    void shouldThrowIllegalArgumentExceptionWhenHypotenuseIsShorterThanCathetus() {
        // given
        CalculatorSinus calculatorSinus = new CalculatorSinus();
        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> calculatorSinus.sinus(5, 3)
        );
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenHypotenuseOrCathetusLessThanZero() {
        // given
        CalculatorSinus calculatorSinus = new CalculatorSinus();
        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> calculatorSinus.sinus(-5, 3));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenEqualToZero() {
        // given
        CalculatorSinus calculatorSinus = new CalculatorSinus();
        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> calculatorSinus.sinus(0, 0));
    }

}