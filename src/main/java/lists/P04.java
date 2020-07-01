package lists;

import java.util.List;

/**
 * Class for getting length of the list.
 */
  final class P04 {

    private P04() {
    }

    /**
     * Get length of the list.
     *
     * @param list list of item
     * @param <T>  type of item
     * @return size of the list
     */
    public static <T> Integer length(final List<T> list) {
        return list.size();
    }
}
