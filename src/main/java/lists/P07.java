package lists;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class for string manipulation
 * </p>
 * Flatten list of strings
 */
public final class P07 {

    private P07() {
    }

    /**
     * Transform a list, possibly holding lists as elements into a 'flat' list by replacing each list with its elements (recursively).
     *
     * @param inputList  mixed lists of items
     * @param typeOfItem item type
     * @return single list of item
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> flatten(final List<?> inputList, final Class<T> typeOfItem) {
        if (inputList.isEmpty()) {
            return Collections.emptyList();
        }
        return inputList.stream()
                .flatMap(obj -> obj instanceof List ? flatten(((List<?>) obj), typeOfItem).stream() : Stream.of(obj))
                .map(obj -> (T) obj)
                .collect(Collectors.toList());

    }
}
