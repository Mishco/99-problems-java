package lists;

import java.util.Comparator;
import java.util.List;

/**
 * We suppose that a list (InList) contains elements that are lists themselves.
 * The objective is to sort the elements of InList according to their length.
 * E.g. short lists first, longer lists later, or vice versa.
 * <p>
 * Example:
 * ?- lsort([[a,b,c],[d,e],[f,g,h],[d,e],[i,j,k,l],[m,n],[o]],L).
 * L = [[o], [d, e], [d, e], [m, n], [a, b, c], [f, g, h], [i, j, k, l]]
 */
public final class P28 {

    private P28() {
    }

    /**
     * Sort list by size of sublist
     *
     * @param input input list of items
     * @return sorted list
     */
    public static List<List<String>> lsort(List<List<String>> input) {
        input.sort(Comparator.comparingInt(List::size));
        return input;
    }

    public static List<List<String>> lfsort(List<List<String>> input) {
        return null;
    }
}
