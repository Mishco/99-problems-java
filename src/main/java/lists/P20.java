package lists;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.rangeClosed;

/**
 * Remove the n-th item from a list.
 * <p>
 * Example:
 * ?- remove_at(X,[a,b,c,d],2,R).
 * X = b
 * R = [a,c,d]
 */
public final class P20 {

    private P20() {
    }

    /**
     * Remove the n-th element.
     *
     * @param list input list of items
     * @param i    index of item which should be removed
     * @param <T>  type of item
     * @return list without element
     */
    public static <T> Object[] removeAt(final List<T> list, final int i) {
        Object[] objects = new Object[2];
        if (Objects.requireNonNull(list).isEmpty()) {
            throw new NoSuchElementException("Empty list is not supported");
        }

        objects[1] = list.get(i - 1);
        objects[0] = rangeClosed(0, list.size() - 1)
                .filter(j -> j != i - 1)
                .mapToObj(list::get)
                .collect(Collectors.toList());

        return objects;
    }
}
