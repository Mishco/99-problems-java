package logiccodes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class P47Test {

    @Test
    void testInfixToPostfix() {
        final var infixToPostfix = P47.infixToPostfix("A and ( B or C ) equ A and B or A and C");
        final var res = "A B C or and A B and equ A C and or";

        assertEquals(res, infixToPostfix);
    }

    @Test
    void shouldGenerateTruthTable() {
        // A B C or and A B and equ A C and or - works well
        final var s = P47.tableList(Arrays.asList("A", "B", "C"), "A and ( B or C ) equ A and B or A and C");
        final String resultTable = "A B C  A B C or and A B and equ A C and or \nF F F  T\nF F T  T\nF T F  T\nF T T  T\nT F F  T\nT F T  T\nT T F  T\nT T T  T\n";

        assertTrue(resultTable.contentEquals(s));
    }

    @Test
    void useTruthTable() {
//        TruthTable(infixToPostfix("A and ( B or C ) equ A and B or A and C")).toString();

        final String table = new TruthTable("A B C or and A B and equ A C and or").toString();
        final String resultTable = "A B C  A B C or and A B and equ A C and or \nF F F  T\nF F T  T\nF T F  T\nF T T  T\nT F F  T\nT F T  T\nT T F  T\nT T T  T\n";

        assertTrue(resultTable.contentEquals(table));
    }


}