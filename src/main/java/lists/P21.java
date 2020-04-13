package lists;

import java.util.List;

/**
 * Insert an item at a given position into a list.
 */
public final class P21 {


    private P21() {
    }

    /**
     * @param input
     * @param i
     * @param item
     * @param <T>
     * @return
     */
    public static <T> List<T> insertAt(final List<T> input,
                                       final int i,
                                       final T item) {
        input.add(i-1, item);

        return input;
    }
}
