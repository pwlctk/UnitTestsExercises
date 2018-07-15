package calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;
    private int lifeCycleMe = 0;

    @BeforeAll
    static void setUp() {
        System.out.println("Start testing!");
    }

    @BeforeEach
    void setUpEach() {
        System.out.println("Before each");
        calculator = new Calculator();
    }

    @AfterEach
    void tearDownEach() {
        System.out.println("After each");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("Testing end!");
    }

    @Test
    void shouldReturn100WhenAdding10And90() {
        // given
        // Calculator calculator = new Calculator();
        // when
        int result = calculator.add(10, 90);
        // then
        assertEquals(100, result);
    }

    @Disabled
    @Test
    @DisplayName("Powinno zwrócić 100, gdy dodamy 50 oraz 50")
    void shouldReturn100WhenAdding50And50() {
        // given
        // Calculator calculator = new Calculator();
        // when
        int result = calculator.add(50, 50);
        // then
        assertEquals(100, result);
    }

    @RepeatedTest(5)
    void shouldCreateNewInstance() {
        // given

        // when

        // then
        assertEquals(0, lifeCycleMe++);
    }

    //test parametryczny z junit-jupiter-params
    @ParameterizedTest
    @ValueSource(strings = {"RED", "GREEN"})
    void shouldTestIfColorIsABaseColor(String color) {
        // given
        Map<String, Boolean> baseColors = new HashMap<>();
        baseColors.put("RED", true);
        baseColors.put("GREEN", true);
        baseColors.put("BLUE", true);
        // when

        // then
        assertTrue(baseColors.getOrDefault(color, false));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testWithValueSource(int argument) {
        assertTrue(argument > 0);
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithSimpleMethodSource(String argument) {
        assertNotNull(argument);
    }

    // możemy zwrócić Stream, Iterable, Iterator
    private static Stream<String> stringProvider() {
        return Stream.of("foo", "bar", "2000");
    }

    @ParameterizedTest
    @CsvSource({"foo, 1", "bar, 2", "baz, 3"})
    void testWithCSVSource(String first, int second) {
        assertNotNull(first);
        assertNotEquals(0, second);
    }

    //Testy warunkowe
    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void shouldRunOnLinuxAndMac() {
        assertEquals("Hello from Linux", "Wait, what?");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void onlyOnJava11() {
        assertEquals("Java 11", "Java 11");
    }

    //Wyrzucanie wyjątku
    @Test
    void shouldParseValidNumber() {
        // given

        // when
        int result = calculator.parse("100");
        // then
        assertEquals(100, result);
    }

    @Test
    void shouldThrowNumberFormatExceptionForInvalidString() {
        // given

        // when

        // then
        assertThrows(NumberFormatException.class, ()
                -> calculator.parse("ble"));
    }

    @Test
    void shouldThrowRightMessageForInvalidString() {
        // given

        // when

        // then
        NumberFormatException result = assertThrows(NumberFormatException.class, ()
                -> calculator.parse("bez znaczenia"));
        assertEquals("Niepoprawny numer", result.getMessage());
    }
}