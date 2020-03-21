package lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for reversing string.
 */
public class P05 {

    private P05() {
    }

    /**
     * Reverse items in list.
     *
     * @param numbers input list
     * @param <T>     type of item in list
     * @return reversed list
     */
    public static <T> List<T> reverse(List<T> numbers) {
        List<T> result = new ArrayList<>();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            result.add(numbers.get(i));
        }
        return result;
    }
}
