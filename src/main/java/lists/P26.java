package lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * In how many ways can a committee of 3 be chosen from a group of 12 people?
 * We all know that there are C(12,3) = 220 possibilities
 * (C(N,K) denotes the well-known binomial coefficients).
 * For pure mathematicians, this result may be great.
 * But we want to really generate all the possibilities (via backtracking).
 * <p>
 * Example:
 * ?- combination(3,[a,b,c,d,e,f],L).
 * L = [a,b,c] ;
 * L = [a,b,d] ;
 * L = [a,b,e] ;
 * ...
 */
public final class P26 {

    private P26() {
    }

    /**
     * List of all combinations.
     *
     * @param input input list of items
     * @param i     count of permuted items
     * @param <T>   type of items
     * @return result list of list
     */
    public static <T> List<List<T>> combinations(final List<T> input,
                                                 final int i) {
        if (i == 1) {
            return input.stream()
                    .map(e -> Stream.of(e)
                            .collect(toList()))
                    .collect(toList());
        }
        if (i == 0 || input.isEmpty()) {
            return Collections.emptyList();
        }
        Map<Boolean, List<T>> tempMap = P17.split(input, 1);
        List<T> first = tempMap.get(true);
        List<T> second = tempMap.get(false);


        List<List<T>> c1 = combinations(second, (i - 1))
                .stream()
                .map(e -> {
                    List<T> l = new ArrayList<>();
                    l.addAll(first);
                    l.addAll(e);
                    return l;
                }).collect(toList());

        c1.addAll(combinations(second, i));
        return c1;
    }


}
