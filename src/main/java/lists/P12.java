package lists;

import java.io.Serializable;
import java.util.AbstractMap;
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
        ArrayList newList = new ArrayList<String>();

        for (Object obj : list) {
            if (obj instanceof SimpleEntry) {
                int count  = (int) ((SimpleEntry) obj).getKey();
                for (int i = 0; i < count; i++) {
                    newList.add(((SimpleEntry) obj).getValue());
                }
            } else {
                newList.add(obj);
            }
        }
        return newList;
    }

}
