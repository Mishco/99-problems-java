package logiccodes;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class P46Test {


    @Test
    void shouldGenerateBasicNANDTable() {
        String table = P45.table(P46::nand);
        String result = "A          B          result\n" +
                "true       true       false\n" +
                "true       false      true\n" +
                "false      true       true\n" +
                "false      false      true";

        assertEquals(table, result);
    }

    @Test
    void shouldGenerateBasicNORTable() {
        String table = P45.table(P46::nor);
        String result = "A          B          result\n" +
                "true       true       false\n" +
                "true       false      false\n" +
                "false      true       false\n" +
                "false      false      true";

        assertEquals(table, result);
    }

    @Test
    void shouldGenerateBasicIMPLTable() {
        String table = P45.table(P46::impl);
        String result = "A          B          result\n" +
                "true       true       true\n" +
                "true       false      false\n" +
                "false      true       true\n" +
                "false      false      true";

        assertEquals(table, result);
    }
}
