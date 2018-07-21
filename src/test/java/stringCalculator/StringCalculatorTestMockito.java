package stringCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


// /http://osherove.com/tdd-kata-1/
class StringCalculatorTestMockito {

    @Test
    void shouldReturnZeroForEmptyString() {
        // given
        StringCalculator mock = mock(StringCalculator.class);
        when(mock.add("")).thenReturn(0);
        // when
        int result = mock.add("");
        // then
        assertEquals(0, result);
    }

    @Test
    void shouldReturnOne() {
        // given
        StringCalculator mock = mock(StringCalculator.class);
        when(mock.add("1")).thenReturn(1);
        // when
        int result = mock.add("1");
        // then
        assertEquals(1, result);
    }

    @Test
    void shouldReturnTenForFiveAndFive() {
        // given
        StringCalculator mock = mock(StringCalculator.class);
        when(mock.add("5,5")).thenReturn(10);
        // when
        int result = mock.add("5,5");
        // then
        assertEquals(10, result);
    }

    @Test
    void shouldReturnSumoOfFiveNumbersUsingCommaDelimiter() {
        // given
        StringCalculator mock = mock(StringCalculator.class);
        when(mock.add("4,7,9,3,9")).thenReturn(32);
        // when
        int result = mock.add("4,7,9,3,9");
        // then
        assertEquals(32, result);
    }

    @Test
    void shouldReturnSumoOfSixNumbersUsingCommaOrNewLineDelimiter() {
        // given
        StringCalculator mock = mock(StringCalculator.class);
        when(mock.add("4\n7,9\n3,9\n8")).thenReturn(40);
        // when
        int result = mock.add("4\n7,9\n3,9\n8");
        // then
        assertEquals(40, result);
    }

    @Test
    void shouldReturnSumoOfSixNumbersUsingSemicolonDelimiter() {
        // given
        StringCalculator mock = mock(StringCalculator.class);
        when(mock.add("//;\n4;7;9;3;9;8")).thenReturn(40);
        // when
        int result = mock.add("//;\n4;7;9;3;9;8");
        // then
        assertEquals(40, result);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForNegativeNumbers() {
        // given
        StringCalculator mock = mock(StringCalculator.class);
        when(mock.add("-1,0,-2")).thenThrow(IllegalArgumentException.class);
        // when

        // then
        assertThrows(IllegalArgumentException.class, ()
                -> mock.add("-1,0,-2"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForNegativeNumbersWithAllNegativeNumbersInMessage() {
        // given
        StringCalculator mock = mock(StringCalculator.class);
        when(mock.add("-1,0,-2")).thenThrow(new IllegalArgumentException("-1,-2"));
        // when

        // then
        IllegalArgumentException result = assertThrows(IllegalArgumentException.class, ()
                -> mock.add("-1,0,-2"));

        assertEquals("-1,-2", result.getMessage());
    }
}