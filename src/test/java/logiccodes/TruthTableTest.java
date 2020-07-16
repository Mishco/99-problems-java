package logiccodes;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

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
        //A and (B or C) equ A and B or A and C
        // A, B, C, or, A, equ, and, B, and, A, or, C, and
        final String table = new TruthTable("A, B, C, or, A, equ, and, B, and, A, or, C, and").toString();
        final String resultTable = "A,B,C A and (B or C) equ A and B or A and C).\n" +
                "T T T T\n" +
                "T T F T\n" +
                "T F T T\n" +
                "T F F T\n" +
                "F T T T\n" +
                "F T F T\n" +
                "F F T T\n" +
                "F F F T";

        assertThat(table, CoreMatchers.containsString(resultTable));
    }


}