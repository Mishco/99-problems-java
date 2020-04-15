package lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class P23 {
    public static <T> List<T> randomSelect(List<T> list, int count) {
        Random random = new Random();
        List<T> resArr = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Object[] objects = P20.removeAt(list, random.nextInt(list.size()));
            resArr.add((T) objects[1]);
        }
        return resArr;
    }
}
