package lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Duplicate the elements of a list.
 */
public final class P14 {

    private P14() {
    }

    /**
     * @param list list items
     * @param <T>  type of item
     * @return duplicated list of elements
     */
    public static <T> List<T> duplicate(final List<T> list) {
        List<T> newTList = new ArrayList<>();
        for (T act : list) {
            newTList.add(act);
            newTList.add(act);
        }
        return newTList;
    }
}
