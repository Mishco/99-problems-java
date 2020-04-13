package lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class for pack list contains repeated elements
 * they should be placed in separate sublist.
 * <pre>
 *  pack([a,a,a,a,b,c,c,a,a,d,e,e,e,e],X).
 *  X = [[a,a,a,a],[b],[c,c],[a,a],[d],[e,e,e,e]]
 * </pre>
 */
public final class P09 {

    private P09() {
    }

    /**
     * Pack list of repeated elements into sublists.
     *
     * @param inputList list of repeated items
     * @param <T>       type of item
     * @return list of separated sublist of repeated elements
     */
    public static <T> List<List<T>> pack(final List<T> inputList) {
        Objects.requireNonNull(inputList, "List must be not null");

        if (inputList.isEmpty()) {
            return new ArrayList<>();
        }

        List<List<T>> resultList = new ArrayList<>();
        List<T> sublist = new ArrayList<>();
        T last = null;
        for (T act : inputList) {
            if (!act.equals(last)) {
                sublist = new ArrayList<>();
                resultList.add(sublist);
            }
            sublist.add(act);
            last = act;
        }
        return resultList;
    }
}
