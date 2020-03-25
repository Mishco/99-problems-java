package lists;

import java.util.Arrays;
import java.util.List;

/**
 * Class for pack list contains repeated elements they should be placed in separate sublists.
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
    public static <T> List<List<T>> pack(List<T> inputList) {
        return Arrays.asList(inputList);
    }
}
