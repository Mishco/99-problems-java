package logiccodes;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * An n-bit Gray code is a sequence of n-bit strings constructed
 * according to certain rules.
 * For example,
 * n = 1: C(1) = ['0','1'].
 * n = 2: C(2) = ['00','01','11','10'].
 * n = 3: C(3) = ['000','001','011','010','110','111','101','100'].
 */
public class P43GrayCode {

    private P43GrayCode() {
    }

    private static String decimalToBinaryNumber(int x,
                                                int n)
    {
        String res;
        var binaryNumber = new int[x];
        int i = 0;
        while (x > 0) {
            binaryNumber[i] = x % 2;
            x /= 2;
            i++;
        }

        res = IntStream
                .iterate(i - 1, j -> j >= 0, j -> j - 1)
                .mapToObj(j -> String.valueOf(binaryNumber[j]))
                .collect(Collectors.joining("", "0"
                        .repeat(Math.max(0, n - i)), ""));

        return res;
    }

    /**
     * Compute gray code numbers
     *
     * @param n input number
     * @return Binary version of gray code
     */
    public static String grayCode(int n)
    {
        return IntStream
                .range(0, 1 << n)
                .map(i -> i ^ (i >> 1))
                .mapToObj(x -> decimalToBinaryNumber(x, n) + "\n")
                .collect(Collectors.joining());
    }

}
