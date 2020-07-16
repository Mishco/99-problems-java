package logiccodes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

import static logiccodes.P40.BOOLEANS;

/**
 * Generalize problem 3.02 in such a way that the logical expression may.
 * contain any number of logical variables. Define table/2 in a way that
 * table(List,Expr) prints the truth table for the expression Expr,
 * which contains the logical variables enumerated in List.
 * <p>
 * Example:
 * ?- table([A,B,C], A and (B or C) equ A and B or A and C).
 * true true true true
 * true true fail true
 * true fail true true
 * true fail fail true
 * fail true true true
 * fail true fail true
 * fail fail true true
 * fail fail fail true
 */
public final class P42 {
    private P42() {
    }

    /**
     * Table list similar to P41.
     *
     * @param variables list of variables
     * @param function  list of functions
     * @return result table.
     */
    public static String tableList(final List<String> variables,
                                   final BiPredicate<List<String>, List<String>> function) {
        List<String> resultBuilder = new ArrayList<>();
//        resultBuilder.add("A          B          result");


        for (String character : variables) {
            resultBuilder.add(character);
            resultBuilder.add("\t");
            for (boolean a : BOOLEANS) {
                for (boolean b : BOOLEANS) {
                    // todo parse function

                    resultBuilder.add(
                            String.format("%-10s %-10s %s",
                                    a,
                                    b));
//                                    function.test(a, b)));
                }
            }
        }
        return String.join("\n", resultBuilder);
    }

    /**
     *
     * @param inputString
     */
    public static void parseStringIntoFunction(
            final String inputString) {

    }
}
