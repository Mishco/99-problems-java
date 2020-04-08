package lists;

import java.util.ArrayList;
import java.util.List;

public class P18 {


    public static <T> List<T> slice(List<T> list, int from, int until) {
        List<T> innerList = new ArrayList<>();

        for (int i = from - 1; i < until; i++) {
            innerList.add(list.get(i));
        }
        return innerList;
    }
}
