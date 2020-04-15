package lists;

import java.util.List;

public class P25 {
    public static <T>List<T> randomPermutation(List<T> collect) {
        return P23.randomSelect(collect, collect.size());
    }
}
