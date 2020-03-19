package lists;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class for returning the secondLast item from list.
 */
public final class P02 {

    private P02() {
    }

    /**
     * Find the second last item from a list.
     *
     * @param numbers input list of items
     * @return second last item
     */
    public static Object secondLast(final List<Integer> numbers) {
        if (numbers.isEmpty() || numbers.size() == 1) {
            throw new NoSuchElementException("Empty list or only "
                    + "one element presented in the list");
        }
        return numbers.get(numbers.size() - 2);
    }
}
