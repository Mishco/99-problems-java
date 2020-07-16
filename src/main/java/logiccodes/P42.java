package logiccodes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                                   final String function) {
        Map<String, Integer> booleanPrecedences = new HashMap<>();
        booleanPrecedences.put("equ", 5);
        booleanPrecedences.put("and", 4);
        booleanPrecedences.put("or", 4);
        booleanPrecedences.put("(", 0);

        System.out.println(variables);

        var rpn = new PostfixToInfix().convertInfixToRPN(function.split(" "), booleanPrecedences).toString();
        return new TruthTable(rpn).toString();
    }
}
