package lists;

import java.util.List;

/**
 * Insert an item at a given position into a list.
 */
public final class P21 {


    private P21() {
    }

    /**
     * Insert an item at a given position into a list.
     *
     * @param input input list of item
     * @param i     given position
     * @param item  item to add
     * @param <T>   type of item
     * @return transformed list
     */
    public static <T> List<T> insertAt(final List<T> input,
                                       final int i,
                                       final T item) {
        input.add(i - 1, item);
        return input;
    }
}
