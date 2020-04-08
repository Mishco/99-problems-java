package lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class for split list.
 */
public final class P17 {

    private P17() {

    }


    /**
     * Split one list of items into two sublist.
     *
     * @param list list to split
     * @param nth  point of split
     * @param <T>  type of item in list
     * @return splitted list
     */
    public static <T> Map<Boolean, List<T>> split(final List<T> list, final int nth) {
        Map<Boolean, List<T>> map = new HashMap<>();
        map.put(true, IntStream.range(0, nth)
                .mapToObj(list::get)
                .collect(Collectors.toList()));
        map.put(false, IntStream.range(nth, list.size()).
                mapToObj(list::get)
                .collect(Collectors.toList()));
        return map;
    }
}
