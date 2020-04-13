package lists;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Get sublist from list
 */
public final class P18 {


    private P18() {
    }

    /**
     * Get slice from list.
     *
     * @param list  list of items
     * @param from  first index from list
     * @param until last index from list
     * @param <T>   type of item
     * @return sublist from list between first and last indices
     */
    public static <T> List<T> slice(final List<T> list,
                                    final int from,
                                    final int until) {
        return IntStream.range(from - 1, until)
                .mapToObj(list::get)
                .collect(Collectors.toList());
    }
}
