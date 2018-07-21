package mockito;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FizzBuzzTest {

    @Test
    public void shouldReturnFizzFor3() {
        // given
        FizzBuzz mock = mock(FizzBuzz.class);
        when(mock.fizzBuzz(3)).thenReturn("Fizz");
        // when
        String result = mock.fizzBuzz(3);
        // then
        assertEquals("Fizz", result);
    }

    @Test
    public void shouldReturnBuzzFor5() {
        // given
        FizzBuzz mock = mock(FizzBuzz.class);
        when(mock.fizzBuzz(5)).thenReturn("Buzz");
        // when
        String result = mock.fizzBuzz(5);
        // then
        assertEquals("Buzz", result);
    }

    @Test
    public void shouldReturnFizzBuzzFor15() {
        // given
        FizzBuzz mock = mock(FizzBuzz.class);
        when(mock.fizzBuzz(15)).thenReturn("FizzBuzz");
        // when
        String result = mock.fizzBuzz(15);
        // then
        assertEquals("FizzBuzz", result);
    }

    @Test
    public void shouldReturn4For4() {
        // given
        FizzBuzz mock = mock(FizzBuzz.class);
        when(mock.fizzBuzz(4)).thenReturn("4");
        FizzBuzzManager fizzBuzzManager = new FizzBuzzManager(mock);
        // when
        String result = fizzBuzzManager.doFizzBuzz(4);
        // then
        assertEquals("4", result);
    }


}