package lists;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * We suppose that a list (InList) contains elements that are lists themselves.
 * The objective is to sort the elements of InList according to their length.
 * E.g. short lists first, longer lists later, or vice versa.
 * <p>
 * Example:
 * ?- lsort([[a,b,c],[d,e],[f,g,h],[d,e],[i,j,k,l],[m,n],[o]],L).
 * L = [[o], [d, e], [d, e], [m, n], [a, b, c], [f, g, h], [i, j, k, l]]
 */
public final class P28 {

    private P28() {
    }

    /**
     * Sort list by size of sublist.
     *
     * @param input input list of items
     * @param <T>   type of item
     * @return sorted list
     */
    public static <T> List<List<T>> lsort(final List<List<T>> input) {
        input.sort(Comparator.comparingInt(List::size));
        return input;
    }

    /**
     * Sort list by frequency of sublist.
     *
     * @param input input list of items
     * @param <T>   type of item
     * @return sorted list
     */
    public static <T> List<List<T>> lfsort(final List<List<T>> input) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        input.stream()
                .map(List::size)
                .forEach(l -> frequencies.put(
                        l,
                        frequencies.compute(l,
                                (k, v) -> v == null
                                        ? 1
                                        : v + 1)));
        return input
                .stream()
                .sorted(Comparator
                        .comparingInt(xs -> frequencies.get(xs.size())))
                .collect(toList());

    }
}
