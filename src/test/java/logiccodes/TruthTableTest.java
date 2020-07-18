package logiccodes;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TruthTableTest {

    @Test
    void testSimpleANDTrueTable() {
        final String table = new TruthTable("a b and").toString();
        final String resultTable = "a b  a b and \n" +
                "F F  F\n" +
                "F T  F\n" +
                "T F  F\n" +
                "T T  T\n";
        assertThat(table, CoreMatchers.containsString(resultTable));
    }

    @Test
    void testSimpleORTrueTable() {
        final String table = new TruthTable("a b or").toString();
        final String resultTable = "a b  a b or \n" +
                "F F  F\n" +
                "F T  T\n" +
                "T F  T\n" +
                "T T  T\n";
        assertThat(table, CoreMatchers.containsString(resultTable));
    }

    @Test
    void testSimpleEQUTrueTable() {
        final String table = new TruthTable("a b equ").toString();
        final String resultTable = "a b  a b equ \n" +
                "F F  T\n" +
                "F T  F\n" +
                "T F  F\n" +
                "T T  T\n";
        assertThat(table, CoreMatchers.containsString(resultTable));
    }

    @Test
    void testComplexTrueTable() {
        final String table = new TruthTable("A B C or and A B and equ A C and or").toString();
        final String resultTable = "A B C  A B C or and A B and equ A C and or \nF F F  T\nF F T  T\nF T F  T\nF T T  T\nT F F  T\nT F T  T\nT T F  T\nT T T  T\n";

        assertTrue(resultTable.contentEquals(table));
    }


}