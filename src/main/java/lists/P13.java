package lists;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Implement the so-called run-length encoding data compression method directly.
 * I.e. don't explicitly create the sublists containing the duplicates,
 * as in problem 1.09, but only count them. As in problem 1.11,
 * simplify the result list by replacing the singleton terms [1,X] by X.
 * </p>
 * Example:
 * ?- encode_direct([a,a,a,a,b,c,c,a,a,d,e,e,e,e],X).
 * X = [[4,a],b,[2,c],[2,a],d,[4,e]]
 */
public class P13 {

    private P13() {
    }

    /**
     * Encode direct all items
     *
     * @param list list of items
     * @return list of simple entries
     */
    public static <T> List<SimpleEntry<Integer, T>> encode_direct(List<String> list) {
        return P09.pack(list)
                .stream()
                .map(sublist -> new SimpleEntry<>(sublist.size(), (T) sublist.get(0)))
                .collect(toList());
    }
}
