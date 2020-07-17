package logiccodes;

import java.util.*;
import java.util.stream.Collectors;

import static logiccodes.P46.equ;

public final class TruthTable {

    private interface Operator {
        boolean evaluate(Deque<Boolean> s);
    }

    /**
     * Variables (e.g.: A, B, C).
     */
    private final List<String> variables;
    /**
     * Symbols (e.g.: and, or, equ).
     */
    private final String[] symbols;
    /**
     * Supported operators and they actions.
     */
    private final Map<String, Operator> operators = new HashMap<>();


    /**
     * Constructs a truth table for the symbols in an expression.
     *
     * @param inputSymbols input symbols
     */
    public TruthTable(final String inputSymbols) {
        String[] splited = inputSymbols.split("\\s+");

        operators.put("and", stack ->
                Boolean.logicalAnd(stack.pop(), stack.pop()));
        operators.put("or", stack ->
                Boolean.logicalOr(stack.pop(), stack.pop()));
        operators.put("equ", stack -> equ(stack.pop(), stack.pop()));
        operators.put("!", stack -> !stack.pop());
        operators.put("^", stack -> !stack.pop().equals(stack.pop()));

        this.variables = Arrays
                .stream(splited)
                .filter(sym ->
                        !operators.containsKey(sym))
                .distinct()
                .collect(Collectors.toList());
        this.symbols = splited;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();

        variables.forEach(variable -> result.append(variable).append(' '));
        result.append(' ');
        Arrays.stream(symbols)
                .forEach(symbol -> result
                        .append(symbol)
                        .append(' '));
        result.append('\n');
        enumerate(variables.size()).forEach(values -> {
            final Iterator<String> i = variables.iterator();
            values.stream().map(value -> String.format(
                    "%-" + i.next().length() + "c ",
                    value ? 'T' : 'F'
            )).forEach(result::append);
            result.append(' ')
                    .append(evaluate(values) ? 'T' : 'F')
                    .append('\n');
        });

        return result.toString();
    }

    /**
     * Recursively generates T/F values.
     *
     * @param size list size
     * @return boolean values
     */
    private static List<List<Boolean>> enumerate(final int size) {
        List<List<Boolean>> arrLst = new ArrayList<>();

        if (1 == size) {
            arrLst.add(Collections.singletonList(false));
            arrLst.add(Collections.singletonList(true));
            return arrLst;
        }
        List<List<Boolean>> enumerate = enumerate(size - 1);
        enumerate.forEach(head -> {
            arrLst.add(Collections.singletonList(false));
            arrLst.add(Collections.singletonList(true));
        });

        return arrLst;

    }

    /**
     * Evaluates the expression for a set of values.
     * Reverse Polish notation makes this bit easy
     *
     * @param enumeration list of boolean
     * @return result table
     */
    private boolean evaluate(final List<Boolean> enumeration) {
        final Iterator<Boolean> i = enumeration.iterator();
        final Map<String, Boolean> values = new HashMap<>();
        final Deque<Boolean> stack = new ArrayDeque<>();

        variables.forEach(v -> values.put(v, i.next()));
        Arrays.stream(symbols).forEach(symbol -> stack.push(
                null == operators.get(symbol)
                        ? values.get(symbol)
                        : operators.get(symbol).evaluate(stack)
        ));
        return stack.pop();
    }
}
