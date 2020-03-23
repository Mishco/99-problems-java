package lists;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class for String manipulation.
 * </p>
 * Find the palindrome
 */
public final class P06 {

    private P06() {
    }


    /**
     * Find if the list of items is palindrome or not.
     *
     * @param list list of items
     * @param <T>  type of item in input list
     * @return true if palindrome, false it not
     */
    public static <T> boolean isPalindrome(List<T> list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        for (int i = 0, j = list.size() - 1; i < list.size() / 2; i++, j--) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
        }
        return true;

    }
}
