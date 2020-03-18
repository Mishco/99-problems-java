/**
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
 * Find the last element of a list.
 */
public final class P01 {

    private P01() {
    }

    /**
     * Find the last element of a list.
     *
     * @param asList list from where will be founded
     * @return last item of the input list
     */
    public static Object last(final List<String> asList) {
        return asList.get(asList.size() - 1);
    }
}
