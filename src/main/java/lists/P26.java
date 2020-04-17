package lists;

import com.google.common.math.BigIntegerMath;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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

    public static <T> List<List<T>> combinations(final List<T> input,
                                                 final int i) {
        List<T> randomSelect = P23.randomSelect(input, i);
        List<List<T>> res = new ArrayList<>();
        // how many items will be in result ??? - math formula for that
        BigInteger binomial = BigIntegerMath.binomial(input.size(), i);
        // but we cannot know if result is not repeating
        while (res.size() != binomial.intValue()) {
            List<T> permutation = P25.randomPermutation(randomSelect);
            //if(!res.contains(permutation)) {
            res.add(permutation);
            //}
        }
        return res;

//        Map<Boolean, List<T>> headAndTail = P17.split(input, 1);
//        List<T> head = headAndTail.get(true);
//        List<T> tail = headAndTail.get(false);
//        List<List<T>> c1 = combinations(tail, (i - 1)).stream().map(e -> {
//            List<T> l = new ArrayList<>();
//            l.addAll(head);
//            l.addAll(e);
//            return l;
//        }).collect(Collectors.toList());
//        List<List<T>> c2 = combinations(tail, i);
//        c1.addAll(c2);
//        return c1;


    }
}
