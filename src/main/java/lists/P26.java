package lists;

import java.util.ArrayList;
import java.util.List;

public class P26 {
    public static <T> List<List<T>> combinations(List<T> input, int i) {
        List<T> randomSelect = P23.randomSelect(input, i);
        List<List<T>> res = new ArrayList<>();
        res.add(P25.randomPermutation(randomSelect));
        return res;
    }
}
