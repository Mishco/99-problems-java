package lists;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Select random from list.
 */
public final class P23 {

    private P23() {
    }

    /**
     * Random select count of items.
     *
     * @param list  list of item
     * @param count number of item to pick up
     * @param <T>   type of item
     * @return random selected item.
     */
    public static <T> List<T> randomSelect(final List<T> list,
                                           final int count) {
        List<T> resArr = new ArrayList<>();
        List<T> actLst = list;
        for (int i = 1; i <= count; i++) {
            Object[] objects = P20.removeAt(actLst,
                    getRandomNumberInRange(actLst.size()));
            actLst = (List<T>) objects[0];
            resArr.add((T) objects[1]);
        }
        return resArr;
    }

    private static int getRandomNumberInRange(final int max) {
        Random r = new SecureRandom();
        return r.nextInt((max - 1) + 1) + 1;
    }

}
