package converter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    void shouldReturn0DegreesOfFahrenheit() {
        // given
        double result = Converter.celsiusToFahrenheit(-17.778);
        // when

        // then
        assertEquals(0, result, 0.001);
    }

    @Test
    void shouldReturn0DegreesOfCelsius() {
        // given
        double result = Converter.fahrenheitToCelsius(32);
        // when

        // then
        assertEquals(0, result);
    }

    @Test
    void shouldReturn2760DegreesOfCelsius() {
        // given
        double result = Converter.fahrenheitToCelsius(5000);
        // when

        // then
        assertEquals(2760, result);
    }

    @Test
    void shouldReturn18032DegreesOfFahrenheit() {
        // given
        double result = Converter.celsiusToFahrenheit(10000);
        // when

        // then
        assertEquals(18032, result);
    }

    @Test
    void shouldThrowExceptionWhenConvertFahrenheitBelowZeroAbsolute() {
        // given

        // when

        // then
        assertThrows(UnsupportedOperationException.class, ()
                -> Converter.fahrenheitToCelsius(-460));
    }

    @Test
    void shouldThrowExceptionWhenConvertCelciusBelowZeroAbsolute() {
        // given

        // when

        // then
        assertThrows(UnsupportedOperationException.class, ()
                -> Converter.celsiusToFahrenheit(-274));
    }
}