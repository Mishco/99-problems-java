package lists;

import java.util.List;

/**
 * Class for finding the K-th element in list.
 */
public final class P03 {

    private P03() {
    }

    /**
     * Find the k-th item in list
     * @param numbers list of items
     * @param i index of the item
     * @return item
     */
    public static Object kth(final List<Integer> numbers, int i) {
        return numbers.get(i);
    }
}
