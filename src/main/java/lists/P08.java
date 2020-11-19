package lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Class for compress duplicates of list elements.
 * If a list contains repeated items, it should be replaced with single copy
 * of the element.
 * <pre>
 *     compress([a,a,a,a,b,c,c,a,a,d,e,e,e,e]).
 *     result = [a,b,c,a,d,e]
 * </pre>
 */
public final class P08 {

    private P08() {
    }

    /**
     * Compress repeated items in list.
     *
     * @param inputList list of item
     * @param <T>       type of item in list
     * @return compressed list of items
     */
    public static <T> List<T> compress(final List<T> inputList) {
        Objects.requireNonNull(inputList, "List must be not null");

        List<T> result = new ArrayList<>();
        if (inputList.isEmpty()) {
            return Collections.emptyList();
        }

        T first = inputList.get(0);
        result.add(first);

        for (T act : inputList) {
            if (!act.equals(first)) {
                first = act;
                result.add(act);
            }
        }

        return result;
    }
}
