package logiccodes;

import java.util.*;

public class PostfixToInfix {

    private static boolean isNumber(final String str) {
        try {
            Double.valueOf(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isLetter(final String str) {
        try {
            return Character.isLetter(str.charAt(0));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * shunting-yard algorithm for convert infix into RPN.
     * RPN (Reverse Polish Notation)
     *
     * @param infixNotation array of symbols infix
     * @return return queue of RPN
     */
    public Queue<String> convertInfixToRPN(final String[] infixNotation,
                                           final Map<String, Integer> precedences) {
        Queue<String> stringQueue = new LinkedList<>();
        Deque<String> arrayDeque = new ArrayDeque<>();

        Arrays.stream(infixNotation).forEachOrdered(token -> {
            if (solveParenthesis(stringQueue, arrayDeque, token)) {
                return;
            }
            if (precedences.containsKey(token)) {
                while (!arrayDeque.isEmpty()
                        && precedences.get(token) <= precedences.get(
                        arrayDeque.peek())) {
                    stringQueue.add(arrayDeque.pop());
                }
                arrayDeque.push(token);
                return;
            }
            if (isNumber(token)) {
                stringQueue.add(token);
                return;
            }
            if (isLetter(token)) {
                stringQueue.add(token);
                return;
            }
            throw new IllegalArgumentException("Invalid input");
        });
        while (!arrayDeque.isEmpty()) {
            stringQueue.add(arrayDeque.pop());
        }
        return stringQueue;
    }

    private boolean solveParenthesis(final Queue<String> stringQueue,
                                     final Deque<String> arrayDeque,
                                     final String token) {
        if ("(".equals(token)) {
            arrayDeque.push(token);
            return true;
        }
        if (")".equals(token)) {
            while (!"(".equals(arrayDeque.peek())) {
                stringQueue.add(arrayDeque.pop());
            }
            arrayDeque.pop();
            return true;
        }
        return false;
    }
}

