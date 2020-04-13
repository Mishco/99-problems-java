package lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Remove the n-th item from a list.
 * <p>
 * Example:
 * ?- remove_at(X,[a,b,c,d],2,R).
 * X = b
 * R = [a,c,d]
 */
public class P20 {

    private P20() {
    }

    /**
     * Remove the n-th element.
     *
     * @param list input list of items
     * @param i    index of item which should be removed
     * @param <T>  type of item
     * @return list without element
     */
    public static <T> Object[] removeAt(final List<T> list, final int i) {
        Object[] objects = new Object[2];
        List<T> tempList = new ArrayList<>();

        // a b c d
        // 0 1 2 3

        // removeAt(2)
        // a c d
        int index = i - 1;
        for (int j = 0; j <= list.size() - 1; j++) {
            if (j == index) {
                objects[1] = list.get(j);
            } else {
                tempList.add(list.get(j));
            }
        }
        objects[0] = tempList;
        return objects;
    }
}
