package lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            Map<Boolean, List<T>> booleanListMap = P17.split(list, countOfItems);
            List<T> firstPart = booleanListMap.get(false);
            List<T> secondPart = booleanListMap.get(true);

            return Stream.concat(firstPart.stream(), secondPart.stream()).collect(Collectors.toList());
        }
        Map<Boolean, List<T>> booleanListMap = P17.split(list, countOfItems + list.size());
        List<T> firstPart = booleanListMap.get(false);
        List<T> secondPart = booleanListMap.get(true);

        return Stream.concat(firstPart.stream(), secondPart.stream()).collect(Collectors.toList());
    }
}
