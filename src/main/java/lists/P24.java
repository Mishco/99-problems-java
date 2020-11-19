package lists;

import java.util.List;

import static lists.P22.range;

/**
 * Lotto: Draw N different random numbers from the set 1..M.
 * The selected numbers shall be put into a result list.
 * Example:
 * ?- lotto(6,49,L).
 * L = [23,1,17,33,21,37]
 */
public final class P24 {

    private P24() {
    }

    /**
     * Random select from interval.
     *
     * @param count count of random items
     * @param min   minimal number of interval
     * @param max   maximum number from interval
     * @return list of integers
     */
    public static List<Integer> randomSelect(final int count,
                                             final int min,
                                             final int max) {
        List<Integer> integerList = range(min, max);
        return P23.randomSelect(integerList, count);
    }
}
