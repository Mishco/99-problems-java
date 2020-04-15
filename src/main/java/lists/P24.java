package lists;

import java.util.List;

import static lists.P22.range;

public final class P24 {

    public static List<Integer> randomSelect(final int count,
                                             final int min,
                                             final int max) {
        List<Integer> integerList = range(min, max);
        return P23.randomSelect(integerList, count);
    }
}
