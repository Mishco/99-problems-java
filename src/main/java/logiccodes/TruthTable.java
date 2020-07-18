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
    private final Map<String, Operator> operators;


    /**
     * Constructs a truth table for the symbols in an expression.
     *
     * @param inputSymbols input symbols
     */
    public TruthTable(final String inputSymbols) {
        String[] splited = inputSymbols.split("\\s+");

        operators = new HashMap<>() {{
            put("and", stack -> Boolean.logicalAnd(stack.pop(), stack.pop()));
            put("or", stack -> Boolean.logicalOr(stack.pop(), stack.pop()));
            put("equ", stack -> equ(stack.pop(), stack.pop()));
            put("!", stack -> !stack.pop());
            put("^", stack -> !stack.pop().equals(stack.pop()));
        }};

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

        for (final String variable : variables) {
            result.append(variable).append(' ');
        }
        result.append(' ');
        for (final String symbol : symbols) {
            result.append(symbol).append(' ');
        }
        result.append('\n');
        for (final List<Boolean> values : enumerate(variables.size())) {
            final Iterator<String> i = variables.iterator();

            for (final Boolean value : values) {
                result.append(
                        String.format(
                                "%-" + i.next().length() + "c ",
                                value ? 'T' : 'F'
                        )
                );
            }
            result.append(' ')
                    .append(evaluate(values) ? 'T' : 'F')
                    .append('\n');
        }

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
        if (1 == size)
            return new ArrayList<>() {{
                add(new ArrayList<>() {{
                    add(false);
                }});
                add(new ArrayList<>() {{
                    add(true);
                }});
            }};

        return new ArrayList<>() {{
            for (final List<Boolean> head : enumerate(size - 1)) {
                add(new ArrayList<>(head) {{
                    add(false);
                }});
                add(new ArrayList<>(head) {{
                    add(true);
                }});
            }
        }};

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
        for (String symbol : symbols) {
            final var tempOperator = operators.get(symbol);
            stack.push(
                    null == tempOperator
                            ? values.get(symbol)
                            : tempOperator.evaluate(stack)
            );
        }
        return stack.pop();

    }
}
