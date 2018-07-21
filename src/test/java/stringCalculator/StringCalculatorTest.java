package stringCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


// /http://osherove.com/tdd-kata-1/
class StringCalculatorTest {

    @Test
    public void shouldReturnZeroForEmptyString() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        // when
        int result = stringCalculator.add("");
        // then
        assertEquals(0, result);
    }

    @Test
    public void shouldReturnOne() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        // when
        int result = stringCalculator.add("1");
        // then
        assertEquals(1, result);
    }

    @Test
    public void shouldReturnTenForFiveAndFive() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        // when
        int result = stringCalculator.add("5,5");
        // then
        assertEquals(10, result);
    }

    @Test
    public void shouldReturnSumoOfFiveNumbersUsingCommaDelimiter() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        // when
        int result = stringCalculator.add("4,7,9,3,9");
        // then
        assertEquals(32, result);
    }

    @Test
    public void shouldReturnSumoOfSixNumbersUsingCommaOrNewLineDelimiter() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        // when
        int result = stringCalculator.add("4\n7,9\n3,9\n8");
        // then
        assertEquals(40, result);
    }

    @Test
    public void shouldReturnSumoOfSixNumbersUsingSemicolonDelimiter() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        // when
        int result = stringCalculator.add("//;\n4;7;9;3;9;8");
        // then
        assertEquals(40, result);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNegativeNumbers() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        // when

        // then
        assertThrows(IllegalArgumentException.class, ()
                -> stringCalculator.add("-1, 0, -2"));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNegativeNumbersWithAllNegativeNumbersInMessage() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        // when

        // then
        IllegalArgumentException result = assertThrows(IllegalArgumentException.class, ()
                -> stringCalculator.add("-1,0,-2"));

        assertEquals("-1,-2", result.getMessage());
    }


}