package lists;

import java.util.Collections;
import java.util.List;

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
    public static List<String> flatten(List<Object> inputList, Class<String> typeOfItem) {
        if (inputList.isEmpty()) {
            return Collections.emptyList();
        }
        if (typeOfItem == null) {
            throw new ClassCastException("Type of item is not valid");
        }
        return Collections.emptyList();
    }
}
