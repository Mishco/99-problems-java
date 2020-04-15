package lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for range list.
 */
public final class P22 {

    private P22() {
    }

    /**
     * Create range list.
     *
     * @param firstIdx  first index
     * @param secondIdx second index
     * @return
     */
    public static List<Integer> range(final int firstIdx,
                                      final int secondIdx) {
        List<Integer> resArr = new ArrayList<>();

        for (int i = firstIdx; i <= secondIdx; i++) {
            resArr.add(i);
        }
        return resArr;
    }
}
