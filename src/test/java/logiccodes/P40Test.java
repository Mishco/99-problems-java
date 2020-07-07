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


}