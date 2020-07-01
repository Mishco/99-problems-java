package lists;

import java.util.Collections;
import java.util.List;

/**
 * Class for reversing string.
 */
  final class P05 {

    private P05() {
    }

    /**
     * Reverse items in list.
     *
     * @param numbers input list
     * @param <T>     type of item in list
     * @return reversed list
     */
    public static <T> List<T> reverse(final List<T> numbers) {
        Collections.reverse(numbers);
        return numbers;
    }
}
