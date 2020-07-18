package logiccodes;

import java.util.*;

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
 * <p>
 * Sources
 * - http://rosettacode.org/wiki/Truth_table
 */
public final class P47 {
    private enum Operator {
        ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);
        final int precedence;

        Operator(int p) {
            precedence = p;
        }
    }

    private static final Map<String, Operator> OPERATOR_MAP = new HashMap<>();

    static {
        OPERATOR_MAP.put("impl", Operator.ONE);
        OPERATOR_MAP.put("or", Operator.TWO);
        OPERATOR_MAP.put("nor", Operator.THREE);
        OPERATOR_MAP.put("xor", Operator.THREE);
        OPERATOR_MAP.put("equ", Operator.THREE);
        OPERATOR_MAP.put("and", Operator.FOUR);
        OPERATOR_MAP.put("nand", Operator.FOUR);
        OPERATOR_MAP.put("not", Operator.FIVE);
    }

    private P47() {

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
        if (variables.isEmpty()) {
            return null;
        }
        return new TruthTable(infixToPostfix(function)).toString();
    }

    private static boolean isHigerPrec(String op, String sub) {
        return (OPERATOR_MAP.containsKey(sub)
                && OPERATOR_MAP.get(sub).precedence
                >= OPERATOR_MAP.get(op).precedence);
    }

    public static String infixToPostfix(String infix) {
        StringBuilder output = new StringBuilder();
        Deque<String> stack = new LinkedList<>();

        Arrays.stream(infix.split("\\s")).forEach(token -> {
            if (OPERATOR_MAP.containsKey(token)) {
                while (!stack.isEmpty() && isHigerPrec(token, stack.peek()))
                    output.append(stack.pop()).append(' ');
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.peek().equals("("))
                    output.append(stack.pop()).append(' ');
                stack.pop();
            } else {
                output.append(token).append(' ');
            }
        });
        while (!stack.isEmpty())
            output.append(stack.pop()).append(' ');

        return output.toString();
    }
}
