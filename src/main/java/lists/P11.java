package lists;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * Modify the result of problem 1.10 in such a way
 * that if an element has no duplicates it is simply copied into the result list.
 * Only elements with duplicates are transferred as [N,E] terms.
 * <p/>
 * <pre>
 * Example:
 * ?- encode_modified([a,a,a,a,b,c,c,a,a,d,e,e,e,e],X).
 * X = [[4,a],b,[2,c],[2,a],d,[4,e]]
 * </pre>
 */
public class P11 {

    private P11() {
    }

    /**
     * Encode modified
     *
     * @param list input list of items
     * @param <T>  type of item
     * @return encoded list, only elements
     */
    public static <T> List<T> encode_modified(List<T> list) {
        List<SimpleEntry<Integer, T>> simpleEntryList = P09.pack(list)
                .stream()
                .map(subList -> new SimpleEntry<>(subList.size(), subList.get(0)))
                .collect(toList());


        List<Object> encodedModifiedList = P09.pack(list)
                .stream()
                .map(sublist -> {
                    if (sublist.size() == 1) {
                        return sublist.get(0);
                    } else {
                        return new SimpleEntry<>(sublist.size(), sublist.get(0));
                    }
                })
                .collect(toList());

        return (List<T>) encodedModifiedList;
    }
}
