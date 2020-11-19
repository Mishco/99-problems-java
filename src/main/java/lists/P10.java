package lists;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

/**
 * Get encode number of repeated elements.
 * <p>
 * Example:
 * ?- encode([a,a,a,a,b,c,c,a,a,d,e,e,e,e],X).
 * X = [[4,a],[1,b],[2,c],[2,a],[1,d],[4,e]]
 */
public final class P10 {

    private P10() {
    }

    /**
     * Use previous P09 to get packed list and only get size of this sublist.
     *
     * @param inputList list of repeated elements
     * @param <T>       type of item
     * @return List of SimpleEntry[count, Element]
     */
    public static <T> List<SimpleEntry<Integer, T>> encode(
            final List<T> inputList) {
        List<SimpleEntry<Integer, T>> simpleEntries = new ArrayList<>();
        Objects.requireNonNull(inputList, "List must be not null");

        if (inputList.isEmpty()) {
            return simpleEntries;
        }

        return P09.pack(inputList)
                .stream()
                .map(subList ->
                        new SimpleEntry<>(subList.size(), subList.get(0)))
                .collect(toList());
    }
}
