package lists;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class for finding the K-th element in list.
 */
public final class P03 {

    private P03() {
    }

    /**
     * Find the k-th item in list
     *
     * @param numbers list of items
     * @param i       index of the item
     * @return item
     */
    public static <T> T kth(final List<T> numbers, final int i) {
        if (numbers.isEmpty()) {
            throw new NoSuchElementException("Empty list");
        }
        if (i >= 0) return numbers.get(i);
        else throw new NoSuchElementException("Invalid index");
    }
}
