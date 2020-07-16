package logiccodes;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

class PostfixToInfixTest {
    /**
     * Sorts precedences with priority.
     */
    private static final int PRIORITY_LEVEL_FIVE = 5;
    /**
     * Sorts precedences with priority.
     */
    private static final int PRIORITY_LEVEL_FOUR = 4;
    /**
     * Sorts precedences with priority.
     */
    private static final int PRIORITY_LEVEL_ZERO = 0;
    private Map<String, Integer> mathPrecedences;
    private Map<String, Integer> booleanPrecedences;

    @BeforeEach
    void setUp() {
        mathPrecedences = new HashMap<>();
        mathPrecedences.put("/", PRIORITY_LEVEL_FIVE);
        mathPrecedences.put("*", PRIORITY_LEVEL_FIVE);
        mathPrecedences.put("+", PRIORITY_LEVEL_FOUR);
        mathPrecedences.put("-", PRIORITY_LEVEL_FOUR);
        mathPrecedences.put("(", PRIORITY_LEVEL_ZERO);

        booleanPrecedences = new HashMap<>();
        booleanPrecedences.put("equ", PRIORITY_LEVEL_FIVE);
        booleanPrecedences.put("and", PRIORITY_LEVEL_FOUR);
        booleanPrecedences.put("or", PRIORITY_LEVEL_FOUR);
        booleanPrecedences.put("(", PRIORITY_LEVEL_ZERO);
    }

    @Test
    void testSimpleInfixToPrefix() {
        String[] infixNotation = {"33", "+", "23"};
        final var strings = new PostfixToInfix().convertInfixToRPN(infixNotation, mathPrecedences).toString();
        assertThat(strings, CoreMatchers.containsString("33, 23, +"));
    }

    @Test
    void testComplexInfixToPrefix() {
        String[] infixNotation2 = {"2", "*", "(", "3", "+", "4", "/", "2", ")"};
        final var rpn = new PostfixToInfix().convertInfixToRPN(infixNotation2, mathPrecedences).toString();
        assertThat(rpn, CoreMatchers.containsString("[2, 3, 4, 2, /, +, *]"));
    }

    @Test
    void testSimpleBooleanInfixToPrefix() {
        String[] infixNotation3 = {"A", "and", "(", "B", "or", "C", ")"};
        final var rpn = new PostfixToInfix().convertInfixToRPN(infixNotation3, booleanPrecedences).toString();
        assertThat(rpn, CoreMatchers.containsString("[A, B, C, or, and]"));
    }

    @Test
    void testComplexBooleanInfixToPrefix() {
        String[] infixNotation2 = {"A", "and", "(", "B", "or", "C", "and", "D", ")"};
        final var rpn = new PostfixToInfix().convertInfixToRPN(infixNotation2, booleanPrecedences).toString();
        assertThat(rpn, CoreMatchers.containsString("[A, B, C, or, D, and, and]"));
    }

    @Test
    void textComplexInfixToPrefix() {
        String input = "A and ( B or C ) equ A and B or A and C";
        String[] strArray = input.split(" ");
        final var rpn = new PostfixToInfix().convertInfixToRPN(strArray, booleanPrecedences).toString();
        assertThat(rpn, CoreMatchers.containsString("[A, B, C, or, A, equ, and, B, and, A, or, C, and]"));
    }
}