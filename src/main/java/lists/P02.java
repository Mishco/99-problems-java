/*
 * Classes with list manipulation.
 * <p>
 * These classes contain public static method with List methods.
 *
 * @author mishcos
 * @version 0.1
 * @since 0.1
 */
package lists;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class for returning the secondLast item from list.
 */
  final class P02 {

    private P02() {
    }

    /**
     * Find the second last item from a list.
     *
     * @param numbers input list of items
     * @return second last item
     */
      static Object secondLast(final List<Integer> numbers) {
        if (numbers.isEmpty() || numbers.size() == 1) {
            throw new NoSuchElementException("Empty list or only "
                    + "one element presented in the list");
        }
        return numbers.get(numbers.size() - 2);
    }
}
