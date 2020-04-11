package lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.abs;

public class P19 {

    private P19() {
    }

    public static <T> List<T> rotate(List<T> list, int countOfItems) {
        if (countOfItems == 0) {
            return list;
        }
        if (countOfItems > 0) {
            Map<Boolean, List<T>> booleanListMap = P17.split(list, countOfItems);
            List<T> firstPart = booleanListMap.get(false);
            List<T> secondPart = booleanListMap.get(true);

            firstPart.addAll(secondPart);
            return firstPart;
        }
        Map<Boolean, List<T>> booleanListMap = P17.split(list, abs(countOfItems));
        List<T> firstPart = booleanListMap.get(false);
        List<T> secondPart = booleanListMap.get(true);

        return Stream.concat(firstPart.stream(), secondPart.stream()).collect(Collectors.toList());
    }
}
