package logiccodes;

import org.junit.jupiter.api.Test;

import static logiccodes.P41.and;
import static logiccodes.P41.or;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class P40Test {



    @Test
    void shouldGenerateTruthTable() {
        String table = P40.table((a, b) -> and(a, or(a, b)));
        String result = "A          B          result\n" +
                "true       true       true\n" +
                "true       false      true\n" +
                "false      true       false\n" +
                "false      false      false";

        assertThat(table, is(equalTo(result)));
    }

    @Test
    void shouldGenerateBasicANDTable() {
        String table = P40.table(P41::and);
        String result = "A          B          result\n" +
                "true       true       true\n" +
                "true       false      false\n" +
                "false      true       false\n" +
                "false      false      false";

        assertThat(table, is(equalTo(result)));
    }

    @Test
    void shouldGenerateBasicORTable() {
        String table = P40.table(P41::or);
        String result = "A          B          result\n" +
                "true       true       true\n" +
                "true       false      true\n" +
                "false      true       true\n" +
                "false      false      false";
        assertThat(table, is(equalTo(result)));
    }

    @Test
    void shouldGenerateBasicEQUTable() {
        String table = P40.table(P41::equ);
        String result = "A          B          result\n" +
                "true       true       true\n" +
                "true       false      false\n" +
                "false      true       false\n" +
                "false      false      true";
        assertThat(table, is(equalTo(result)));
    }

    @Test
    void shouldGenerateBasicXORTable() {
        String table = P40.table(P41::xor);
        String result = "A          B          result\n" +
                "true       true       false\n" +
                "true       false      true\n" +
                "false      true       true\n" +
                "false      false      false";
        assertThat(table, is(equalTo(result)));
    }

}