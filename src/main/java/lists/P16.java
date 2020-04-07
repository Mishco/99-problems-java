package lists;

import java.util.ArrayList;
import java.util.List;

public final class P16 {

    private P16() {
    }

    /**
     * Remove every i-th item from list
     *
     * @param list list of items
     * @param nth    i-th integer value
     * @param <T>  type of item
     * @return updated list
     */
    public static <T> List<T> dropEveryNth(List<T> list, Integer nth) {
        if (nth > list.size() || nth <= 0) {
            return list;
        }
        List<T> updatedList = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            if ((j + 1) % nth != 0) {
                updatedList.add(list.get(j));
            }
        }
        return updatedList;
    }
}