package lists;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Given a run-length code list generated as specified in problem P11.
 * Construct its uncompressed version.
 */
public final class P12 {

    private P12() {
    }


    /**
     * Uncompressed list of items.
     *
     * @param list input list of items
     * @param <T>  type of item
     * @return list of uncompressed list
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> decode(final List<Object> list) {
        List<Object> newList = new ArrayList<>();
        for (Object obj : list) {
            if (obj instanceof SimpleEntry) {
                IntStream.range(0, (Integer) ((SimpleEntry) obj)
                        .getKey())
                        .mapToObj(i -> ((SimpleEntry) obj).getValue())
                        .forEach(newList::add);
            } else {
                newList.add(obj);
            }
        }
        return (List<T>) newList;
    }

}
