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

/**
 * Class for returning the secondLast item from list
 */
public class P02 {

    private P02() {
    }

    public static Object secondLast(List<Integer> numbers) {
        return numbers.get(numbers.size() - 2);
    }
}
