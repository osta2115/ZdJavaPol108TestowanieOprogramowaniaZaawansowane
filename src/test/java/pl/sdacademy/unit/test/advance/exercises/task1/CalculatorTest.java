package pl.sdacademy.unit.test.advance.exercises.task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.sdacademy.unit.test.advance.exercises.exceptions.CalculatorService;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("multiplyResults")
    void shouldReturnCorrectMultiplyResult(double inputA, double inputB, double expectedResult) {
        //when
        double result = Calculator.multiply(inputA, inputB);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("divisionResults")
    void shouldReturnCorrectDivisionResult(double inputA, double inputB, double expectedResult) {
        //when
        double result = Calculator.division(inputA, inputB);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldReturnExceptionWhenSecondDigitIsZero() {
       //when & then
        assertThatThrownBy(() -> Calculator.division(4, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("b can't be 0");
    }

    private static Stream<Arguments> divisionResults() {
        return Stream.of(
          Arguments.of(2, 1, 2),
          Arguments.of(-2, 1, -2),
          Arguments.of(-2, -1, 2),
          Arguments.of(2, 0.5, 4)
        );
    }

    private static Stream<Arguments> multiplyResults() {
        return Stream.of(
                Arguments.of(2, 2, 4),
                Arguments.of(1.2D, 2, 2.4D),
                Arguments.of(-2, 2, -4),
                Arguments.of(-0.2, 5, -1)
        );
    }

}