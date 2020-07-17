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
        private final int precedence;

        Operator(final int p) {
            precedence = p;
        }
    }

    /**
     * Operands.
     */
    private static final Map<String, Operator> OPERANDS = new HashMap<>();

    private P47() {
        OPERANDS.put("impl", Operator.ONE);
        OPERANDS.put("or", Operator.TWO);
        OPERANDS.put("nor", Operator.THREE);
        OPERANDS.put("xor", Operator.THREE);
        OPERANDS.put("equ", Operator.THREE);
        OPERANDS.put("and", Operator.FOUR);
        OPERANDS.put("nand", Operator.FOUR);
        OPERANDS.put("not", Operator.FIVE);
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
        return (OPERANDS.containsKey(sub)
                && OPERANDS.get(sub).precedence
                >= OPERANDS.get(op).precedence);
    }

    private static String infixToPostfix(final String infix) {
        StringBuilder output = new StringBuilder();
        Deque<String> stack = new LinkedList<>();

        Arrays.stream(infix.split("\\s")).forEach(token -> {
            if (OPERANDS.containsKey(token)) {
                while (!stack.isEmpty() && isHigerPrec(token, stack.peek())) {
                    output.append(stack.pop()).append(' ');
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.peek().equals("(")) {
                    output.append(stack.pop()).append(' ');
                }
                stack.pop();
            } else {
                output.append(token).append(' ');
            }
        });
        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(' ');
        }

        return output.toString();
    }
}
