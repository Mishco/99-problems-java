package logiccodes;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class P40Test {

    private Boolean or(final Boolean a, final Boolean b) {
        return a || b;
    }

    private Boolean and(final Boolean a, final Boolean b) {
        return a && b;
    }

    private Boolean equ(final Boolean a, final Boolean b) {
        return or(and(a, b), and(!(a), !(b)));
    }

    private Boolean xor(final Boolean a, final Boolean b) {
        return !(equ(a, b));
    }

    private Boolean nand(final Boolean a, final Boolean b) {
        return !(and(a, b));
    }

    private Boolean nor(final Boolean a, final Boolean b) {
        return !(or(a, b));
    }

    private Boolean impl(final Boolean a, final Boolean b) {
        return or(!a, b);
    }

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
        String table = P40.table(this::and);
        String result = "A          B          result\n" +
                "true       true       true\n" +
                "true       false      false\n" +
                "false      true       false\n" +
                "false      false      false";

        assertThat(table, is(equalTo(result)));
    }

    @Test
    void shouldGenerateBasicORTable() {
        String table = P40.table(this::or);
        String result = "A          B          result\n" +
                "true       true       true\n" +
                "true       false      true\n" +
                "false      true       true\n" +
                "false      false      false";
        assertThat(table, is(equalTo(result)));
    }

    @Test
    void shouldGenerateBasicEQUTable() {
        String table = P40.table(this::equ);
        String result = "A          B          result\n" +
                "true       true       true\n" +
                "true       false      false\n" +
                "false      true       false\n" +
                "false      false      true";
        assertThat(table, is(equalTo(result)));
    }

    @Test
    void shouldGenerateBasicXORTable() {
        String table = P40.table(this::xor);
        String result = "A          B          result\n" +
                "true       true       false\n" +
                "true       false      true\n" +
                "false      true       true\n" +
                "false      false      false";
        assertThat(table, is(equalTo(result)));
    }

}