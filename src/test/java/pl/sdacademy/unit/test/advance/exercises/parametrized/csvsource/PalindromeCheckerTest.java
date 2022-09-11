package pl.sdacademy.unit.test.advance.exercises.parametrized.csvsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    @ParameterizedTest
    @CsvSource({"kajak, true",
                "wow, true",
                "Radar, true",
                "ala, true",
                "kobyla ma maly bok, true",
                "java, false",
                "programowanie, false"})
    void shouldVerifyPalindrome(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult,result);
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/palindrome.csv")
    void shouldVerifyPalindrome_csvFileSource(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult,result);
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/palindrome2.csv",
            numLinesToSkip = 10,
            delimiter = '|')
    void shouldVerifyPalindrome_csvFileSource2(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult,result);
        assertThat(result).isEqualTo(expectedResult);
    }

}