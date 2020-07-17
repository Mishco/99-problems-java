package logiccodes;

import org.junit.jupiter.api.Test;

import static logiccodes.P46.and;
import static logiccodes.P46.or;
import static org.junit.Assert.assertEquals;

class P45Test {


    @Test
    void shouldGenerateTruthTable() {
        String table = P45.table((a, b) -> and(a, or(a, b)));
        String result = "A          B          result\n" +
                "true       true       true\n" +
                "true       false      true\n" +
                "false      true       false\n" +
                "false      false      false";

        assertEquals(table, result);
    }

    @Test
    void shouldGenerateBasicANDTable() {
        String table = P45.table(P46::and);
        String result = "A          B          result\n" +
                "true       true       true\n" +
                "true       false      false\n" +
                "false      true       false\n" +
                "false      false      false";

        assertEquals(table, result);
    }

    @Test
    void shouldGenerateBasicORTable() {
        String table = P45.table(P46::or);
        String result = "A          B          result\n" +
                "true       true       true\n" +
                "true       false      true\n" +
                "false      true       true\n" +
                "false      false      false";
        assertEquals(table, result);
    }

    @Test
    void shouldGenerateBasicEQUTable() {
        String table = P45.table(P46::equ);
        String result = "A          B          result\n" +
                "true       true       true\n" +
                "true       false      false\n" +
                "false      true       false\n" +
                "false      false      true";
        assertEquals(table, result);
    }

    @Test
    void shouldGenerateBasicXORTable() {
        String table = P45.table(P46::xor);
        String result = "A          B          result\n" +
                "true       true       false\n" +
                "true       false      true\n" +
                "false      true       true\n" +
                "false      false      false";
        assertEquals(table, result);
    }

}