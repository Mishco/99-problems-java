package lists;

import java.util.List;

/**
 * a) In how many ways can a group of 9 people work in 3 disjoint subgroups
 * of 2, 3 and 4 persons?
 * Write a predicate that generates all the possibilities via backtracking.
 * <p>
 * Example:
 * ?- group3([aldo,beat,carla,david,evi,flip,gary,hugo,ida],G1,G2,G3).
 * G1 = [aldo,beat], G2 = [carla,david,evi], G3 = [flip,gary,hugo,ida]
 * ...
 * b) Generalize the above predicate in a way that we can specify
 * a list of group sizes and the predicate will return a list of groups.
 * <p>
 * Example:
 * ?- group([aldo,beat,carla,david,evi,flip,gary,hugo,ida],[2,2,5],Gs).
 * Gs = [[aldo,beat],[carla,david],[evi,flip,gary,hugo,ida]]
 * ...
 * Note that we do not want permutations of the group members;
 * i.e. [[aldo,beat],...] is the same solution as [[beat,aldo],...].
 * However, we make a difference between [[aldo,beat],[carla,david],...]
 * and [[carla,david],[aldo,beat],...].
 * <p>
 * You may find more about this combinatorial problem in
 * a good book on discrete mathematics
 * under the term "multinomial coefficients".
 */
public class P27 {
    public static <T> List<List<List<T>>> group3(List<T> input) {
        return null;
    }

    public static <T> List<List<List<T>>> group(List<T> input, List<Integer> collect) {
        return null;
    }
}
