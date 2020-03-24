package lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public final class P08 {

    private P08() {
    }

    public static <T> List<T> compress(List<T> inputList) {
        Objects.requireNonNull(inputList, "List must be not null");

        List<T> result = new ArrayList<>();
        if (inputList.isEmpty()) {
            return Collections.emptyList();
        }

        T first = inputList.get(0);
        result.add(first);

        for (T act : inputList) {
            if (!act.equals(first)) {
                first = act;
                result.add(act);
            }
        }

        return result;
    }
}
