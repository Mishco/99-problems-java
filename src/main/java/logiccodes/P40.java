package logiccodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public final class P40 {

    /**
     * Default values of table for input params.
     */
    static final List<Boolean> BOOLEANS = Arrays.asList(true, false);

    private P40() {
    }

    /**
     * A logical expression in two variables can then be written.
     * in prefix notation,
     * as in the following example: and(or(A,B),nand(A,B)).
     *
     * @param function input function
     * @return String table
     */
    public static String table(final BiPredicate<Boolean, Boolean> function) {
        List<String> resultBuilder = new ArrayList<>();
        resultBuilder.add("A          B          result");
        for (boolean a : BOOLEANS) {
            for (boolean b : BOOLEANS) {
                resultBuilder.add(
                        String.format("%-10s %-10s %s",
                                a,
                                b,
                                function.test(a, b)));
            }
        }
        return String.join("\n", resultBuilder);
    }
}
