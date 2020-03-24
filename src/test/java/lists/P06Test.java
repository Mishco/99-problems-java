package lists;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class P06Test {


    @ParameterizedTest
    @MethodSource("generateValidPalindromeStream")
    public void testValidPalindrome(List<String> list) {
        assertTrue(P06.isPalindrome(list));
    }

    @ParameterizedTest
    @MethodSource("generateInvalidPalindromes")
    public void testInvalidPalindrome(List<String> list) {
        assertFalse(P06.isPalindrome(list));
    }

    private static Stream<Arguments> generateValidPalindromeStream() {
        List<Arguments> listOfArguments = new LinkedList<>();
        listOfArguments.add(Arguments.of(Arrays.asList("x", "a", "m", "a", "x")));
        listOfArguments.add(Arguments.of(Arrays.asList("b", "a", "b")));
        listOfArguments.add(Arguments.of(Arrays.asList("b", "a", "a", "b")));
        listOfArguments.add(Arguments.of(Arrays.asList("a", "a", "a", "a", "a")));
        return listOfArguments.stream();
    }

    private static Stream<Arguments> generateInvalidPalindromes() {
        List<Arguments> listOfArguments = new LinkedList<>();
        listOfArguments.add(Arguments.of(Arrays.asList("x", "m", "a", "x")));
        listOfArguments.add(Arguments.of(Arrays.asList("a", "b")));
        listOfArguments.add(Arguments.of(Arrays.asList("a", "a", "b")));
        listOfArguments.add(Arguments.of(Arrays.asList("a", "y", "a", "a", "a")));
        listOfArguments.add(Arguments.of(Arrays.asList("Sator", "Tenet", "Opera", "Rotas")));
        return listOfArguments.stream();
    }
}