package lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17 {

    /**
     * @param list list to split
     * @param nth  point of split
     * @param <T>  type of item in list
     * @return splitted list
     */
    public static <T> Map<Boolean, List<T>> split(List<T> list, int nth) {
        List<T> firstLi = new ArrayList<>();
        List<T> secondList = new ArrayList<>();
        for (int i = 0; i < nth; i++) {
            firstLi.add(list.get(i));
        }
        for (int i = nth; i < list.size(); i++) {
            secondList.add(list.get(i));
        }
        Map map = new HashMap();
        map.put(true, firstLi);
        map.put(false, secondList);
        return map;
    }
}
