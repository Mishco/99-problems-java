package logiccodes;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

class P41Test {


    @Test
    void shouldGenerateBasicNANDTable() {
        String table = P40.table(P41::nand);
        String result = "A          B          result\n" +
                "true       true       false\n" +
                "true       false      true\n" +
                "false      true       true\n" +
                "false      false      true";

        assertThat(table, is(equalTo(result)));
    }

}
