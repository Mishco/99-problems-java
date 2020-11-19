package lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Duplicate the elements of a list a given number of times.
 */
public final class P15 {

    private P15() {
    }

    /**
     * Duplicate items in list.
     *
     * @param list            input list of items.
     * @param numberDuplicate number of item to duplicate.
     * @param <T>             type of item.
     * @return duplicated list of items
     */
    public static <T> List<T> duplicate(final List<T> list,
                                        final Integer numberDuplicate) {
        List<T> newTList = new ArrayList<>();
        for (T act : list) {
            for (int j = 0; j < numberDuplicate; j++) {
                newTList.add(act);
            }
        }
        return newTList;
    }

    /**
     * Duplicate items in list.
     *
     * @param list            input list of items
     * @param numberDuplicate number of item to duplicate
     * @param <T>             type of item
     * @return duplicated list of items
     */
    public static <T> List<T> duplicateStream(final List<T> list,
                                              final Integer numberDuplicate) {
        return list.stream()
                .flatMap(item -> Collections.nCopies(numberDuplicate, item)
                        .stream())
                .collect(Collectors.toList());
    }
}
