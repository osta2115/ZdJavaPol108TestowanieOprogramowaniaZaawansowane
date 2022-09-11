package pl.sdacademy.unit.test.advance.exercises.exceptions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    @ParameterizedTest
    @MethodSource("dataProvider")
    void shouldThrowExceptionWhenAnyOfArgumentAreNull(String a, String b) {
        //when & then
        assertThrows(IllegalArgumentException.class, () -> CalculatorService.add(a, b));

        assertThatThrownBy(() -> CalculatorService.add(a, b))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Arguments 'a' and 'b' are required.");
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, "123"),
                Arguments.of("123", null)
        );
    }

}