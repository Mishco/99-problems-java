package lists;

import java.io.Serializable;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a run-length code list generated as specified in problem P11.
 * Construct its uncompressed version.
 */
public class P12 {

    private P12() {
    }


    /**
     * Uncompressed list
     *
     * @param list input list of items
     * @param <T>  type of item
     * @return list of uncompressed list
     */
    public static <T> List<T> decode(List<Serializable> list) {
        List<Object> newList = new ArrayList<>();

        for (Object obj : list) {
            if (obj instanceof SimpleEntry) {
                for (int i = 0; i < (int) ((SimpleEntry) obj).getKey(); i++) {
                    newList.add(((SimpleEntry) obj).getValue());
                }
            } else {
                newList.add(obj);
            }
        }
        return (List<T>) newList;
    }

}
