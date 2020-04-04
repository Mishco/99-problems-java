package lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Duplicate the elements of a list a given number of times.
 */
public class P15 {

    private P15() {
    }

    /**
     * Duplicate items in list.
     *
     * @param list input list of items.
     * @param i    number of item to duplicate.
     * @param <T>  type of item.
     * @return duplicated list of items
     */
    public static <T> List<T> duplicate(List<T> list, Integer numberOfduplicate) {
        List<T> newTList = new ArrayList<>();
        for (T act : list) {
            for (int j = 0; j < numberOfduplicate; j++) {
                newTList.add(act);
            }
        }
        return newTList;
    }
}
