package logiccodes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P43GrayCodeTest {

    @Test
    void testGrayCodeFor3() {
        final var grayCode = P43GrayCode.grayCode(3);
        final var res = "000\n" +
                "001\n" +
                "011\n" +
                "010\n" +
                "110\n" +
                "111\n" +
                "101\n" +
                "100\n";

        assertEquals(res, grayCode);
    }

    @Test
    void testGrayCodeFor2() {
        final var grayCode = P43GrayCode.grayCode(2);
        final var res = "00\n" +
                "01\n" +
                "11\n" +
                "10\n";

        assertEquals(res, grayCode);
    }

}