package lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Examples:
 * ?- rotate([a,b,c,d,e,f,g,h],3,X).
 * X = [d,e,f,g,h,a,b,c]
 * <p>
 * ?- rotate([a,b,c,d,e,f,g,h],-2,X).
 * X = [g,h,a,b,c,d,e,f]
 */
public final class P19 {

    private P19() {
    }

    /**
     * Rotate list of item.
     *
     * @param list         list of item
     * @param countOfItems how many items will be rotate
     * @param <T>          type of item
     * @return rotated list
     */
    public static <T> List<T> rotate(final List<T> list, final int countOfItems) {
        if (countOfItems == 0) {
            return list;
        }
        if (countOfItems > 0) {
            return extractAndContactList(P17.split(list, countOfItems));
        }
        return extractAndContactList(P17.split(list, countOfItems + list.size()));
    }

    private static <T> List<T> extractAndContactList(Map<Boolean, List<T>> booleanListMap) {
        List<T> firstPart = booleanListMap.get(false);
        List<T> secondPart = booleanListMap.get(true);

        return Stream.concat(firstPart.stream(), secondPart.stream()).collect(Collectors.toList());
    }
}
