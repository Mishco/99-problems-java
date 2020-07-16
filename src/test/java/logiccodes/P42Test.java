package logiccodes;

import org.junit.jupiter.api.Test;

import java.util.Stack;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static logiccodes.P41.and;
import static logiccodes.P41.or;
import static org.junit.Assert.assertEquals;

class P42Test {


    @Test
    void testParsingString() {
//        final var inputString = "A and (B or C) equ A and B or A and C";
//        P42.parseStringIntoFunction(inputString);

        boolean[] all = {false, true};
        for (boolean a : all) {
            for (boolean b : all) {
                boolean c = a ^ b;
                System.out.println(a + " ^ " + b + " = " + c);
            }
        }


        String[] expressions = {"16 and 11", "12 * 5", "27 / 3", "2 - 8"};
        String pattern = "(\\d+)\\s+([-and/])\\s+(\\d+)";

        for (var expression : expressions) {

            Pattern p = Pattern.compile(pattern);
            Matcher matcher = p.matcher(expression);

            while (matcher.find()) {

                int val1 = Integer.parseInt(matcher.group(1));
                int val2 = Integer.parseInt(matcher.group(3));
                String oper = matcher.group(2);

                var result = switch (oper) {
                    case "+" -> String.format("%s = %d", expression, val1 + val2);
                    case "-" -> String.format("%s = %d", expression, val1 - val2);
                    case "*" -> String.format("%s = %d", expression, val1 * val2);
                    case "/" -> String.format("%s = %d", expression, val1 / val2);
                    default -> "Unknown operator";
                };

                System.out.println(result);
            }
        }
    }

    @Test
    void shouldGenerateTruthTable() {
        // table([A,B,C], A and (B or C) equ A and B or A and C)
//        String table = P42.tableList(Arrays.asList("A", "B", "C"), "A and (B or C) equ A and B or A and C");

//        String result = "A          B          result\n" +
//                "true       true       true\n" +
//                "true       false      true\n" +
//                "false      true       false\n" +
//                "false      false      false";
//
//        assertEquals(table, result);

//        Supplier<Stream<NamedPredicate<Person>>> truthTable
//                = predicates.stream() // start with plain predicates
//                .<Supplier<Stream<NamedPredicate<Person>>>>map(
//                        // generate a supplier which creates a stream of
//                        // true-predicate and false-predicate
//                        p -> () -> Stream.of(
//                                new NamedPredicate<>(p, "T"),
//                                new NamedPredicate<>(p.negate(), "F")))
//                .reduce(
//                        // reduce each pair of suppliers to the single supplier
//                        // which produces a Cartesian product stream
//                        (s1, s2) -> () -> s1.get().flatMap(np1 -> s2.get()
//                                .map(np2 -> new NamedPredicate<>(np1.and(np2), np1+" "+np2))))
//                // no input predicates? Fine, produce empty stream then
//                .orElse(Stream::empty);
    }


}