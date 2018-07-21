package riskCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RiskCalculatorTest {
    private RiskCalculator riskCalculator;

    @BeforeEach
    void setUp() {
        riskCalculator = new RiskCalculator();
    }

    //w tym wypadku chyba nie ma sensu używać testu parametrycznego?
    @Test
    void shouldReturnZeroForImpactAndLikelihoodValuesEquals0() {
        // given

        // when
        String result = riskCalculator.calculate(0, 0);
        // then

        Assertions.assertEquals("zero", result);
    }

    @ParameterizedTest
    @CsvSource({"-1, 2", "0, 5", "-3, -3", "5, 5"})
    void shouldThrowIllegalArgumentExceptionForCsvSourceValues(int impact, int likelihood) {
        // given

        // when

        // then
        assertThrows(IllegalArgumentException.class, ()
                -> riskCalculator.calculate(impact, likelihood));
    }

    @ParameterizedTest
    @CsvSource({"3, 4", "4, 3", "4, 4"})
    void shouldReturnHighForCsvSourceValues(int impact, int likelihood) {
        // given

        // when
        String result = riskCalculator.calculate(impact, likelihood);
        // then
        assertEquals("high", result);
    }

    @ParameterizedTest
    @CsvSource({"2, 3", "3, 3", "3, 2"})
    void shouldReturnMediumForCsvSourceValues(int impact, int likelihood) {
        // given

        // when
        String result = riskCalculator.calculate(impact, likelihood);
        // then
        assertEquals("medium", result);
    }

    @ParameterizedTest
    @CsvSource({"1, 0", "0, 1", "1, 1", "1, 2", "2, 1", "2, 2"})
    void shouldReturnSmallForCsvSourceValues(int impact, int likelihood) {
        // given

        // when
        String result = riskCalculator.calculate(impact, likelihood);
        // then
        assertEquals("small", result);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void shouldReturnMediumForValueSourceImpactArguments(int impact) {
        // given

        // when
        String result = riskCalculator.calculate(impact, 3);
        // then
        assertEquals("medium", result);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void shouldReturnMediumForValueSourceLikelihoodArguments(int likelihood) {
        // given

        // when
        String result = riskCalculator.calculate(3, likelihood);
        // then
        assertEquals("medium", result);
    }
}