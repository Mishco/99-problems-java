package arithmetic;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public final class P34 {

    private P34() {
    }

    /**
     * A list of Goldbach compositions.
     *
     * @param inputRange input list of items
     * @return List of goldbach entries
     */
    public static List<SimpleEntry<Integer, List<Integer>>> goldbachList(
            final IntStream inputRange
    ) {
        return inputRange
                .filter(n -> n % 2 == 0 && n > 2)
                .mapToObj(even -> new SimpleEntry<>(even, P33.goldbach(even)))
                .collect(toList());
    }

    /**
     * A list of Goldbach compositions.
     *
     * @param inputRange input list of item
     * @param interval   greatest than this value
     * @return list of goldbach entries
     */
    public static List<SimpleEntry<Integer, List<Integer>>> goldbachInterval(
            final IntStream inputRange,
            final int interval
    ) {
        List<SimpleEntry<Integer, List<Integer>>> list = new ArrayList<>();
        for (SimpleEntry<Integer, List<Integer>> g : goldbachList(inputRange)) {
            if (g.getValue().get(0) > interval && g.getValue().get(1) > interval) {
                list.add(g);
            }
        }
        return list;
    }
}
