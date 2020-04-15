package lists;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class P23 {
    public static <T> List<T> randomSelect(List<T> list, int count) {
        List<T> resArr = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            Object[] objects = P20.removeAt(list, getRandomNumberInRange(list.size()));
            resArr.add((T) objects[1]);
        }
        return resArr;
    }

    private static int getRandomNumberInRange(int max) {
        Random r = new SecureRandom();
        return r.nextInt((max - 1) + 1) + 1;
    }

}
