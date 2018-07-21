package line;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    private Line line;

    @Test
    void shouldThrowArithmeticExceptionWhenX1SubtractX0EqualsZero() {
        // given
        line = new Line(0, 0, 0, 0);
        // when

        // then
        assertThrows(ArithmeticException.class, ()
                -> line.getSlope());
    }

    @Test
    void shouldReturn4ForY0Equals2Y1Equals10X0Equals2X1Equals4() {
        // given
        line = new Line(2, 2, 4, 10);
        // when
        double result = line.getSlope();
        // then
        assertEquals(4, result);
    }

    @Test
    void shouldReturn2ForY0Equals2Y1Equals2X0Equals2X1Equals4() {
        // given
        line = new Line(2, 2, 4, 2);
        // when
        double result = line.getDistance();
        // then
        assertEquals(2, result);
    }

    @Test
    void shouldReturnTrueWhenLine1IsParallelToLine2() {
        // given
        line = new Line(2, 2, 4, 2);
        Line parallelLine = new Line(4, 2, 6, 2);
        // when
        boolean result = line.parallelTo(parallelLine);
        // then
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenLine1IsNotParallelToLine2() {
        // given
        line = new Line(2, 2, 4, 2);
        Line parallelLine = new Line(5, 2, 10, 3);
        // when
        boolean result = line.parallelTo(parallelLine);
        // then
        assertFalse(result);
    }
}