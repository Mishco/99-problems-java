package lists;

import java.util.List;

/**
 * Generate a random permutation of the elements of a list.
 * Example:
 * ?- rnd_permu([a,b,c,d,e,f],L).
 * L = [b,a,d,c,e,f]
 */
public final class P25 {

    private P25() {
    }

    /**
     * Permuted list of items.
     *
     * @param collect collect of items
     * @param <T>     type of item
     * @return list of permuted items
     */
    public static <T> List<T> randomPermutation(final List<T> collect) {
        return P23.randomSelect(collect, collect.size());
    }
}
