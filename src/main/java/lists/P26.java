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

    public static <T> List<List<T>> combinations(List<T> input, int i) {
        List<T> randomSelect = P23.randomSelect(input, i);
        List<List<T>> res = new ArrayList<>();
        // how many items will be in result ??? - math formula for that
        BigInteger binomial = BigIntegerMath.binomial(input.size(), i);
        // but we cannot know if result is not repeating
        for (int j = 0; j < binomial.intValue(); j++) {
            res.add(P25.randomPermutation(randomSelect));
        }
        return res;
    }
}
