package lists;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class for remove every n-th item from list.
 */
public final class P16 {

    private P16() {
    }

    /**
     * Remove every i-th item from list.
     *
     * @param list list of items
     * @param nth  i-th integer value
     * @param <T>  type of item
     * @return updated list
     */
    public static <T> List<T> dropEveryNth(final List<T> list,
                                           final Integer nth) {
        if (nth > list.size() || nth <= 0) {
            return list;
        }
        return IntStream.range(0, list.size())
                .filter(j -> (j + 1) % nth != 0)
                .mapToObj(list::get)
                .collect(Collectors.toList());
    }
}