package lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

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
public final class P27 {


    private P27() {
    }

    private static <T> List<T> remaining(final List<T> list,
                                         final List<T> c) {
        return list
                .stream()
                .filter(e -> !c.contains(e))
                .collect(toList());
    }

    /**
     * Multinomial coefficients for defined parameters.
     *
     * @param input input list
     * @param <T>   type of item
     * @return list of items
     */
    public static <T> List<List<List<T>>> group3(final List<T> input) {
        final int two = 2;
        final int third = 3;
        List<List<List<T>>> result = new ArrayList<>();
        P26.combinations(input, two).forEach(combinationOf2 -> {
            List<T> r = remaining(input, combinationOf2);
            P26.combinations(r, third).stream().map(combinationOf3 -> Stream.of(
                    combinationOf2,
                    combinationOf3,
                    remaining(r, combinationOf3))
                    .collect(toList())).forEach(result::add);
        });
        return result;
    }

    /**
     * Multinomial coefficients for input parameters.
     *
     * @param input   input list of items
     * @param collect list of parameters
     * @param <T>     type of item
     * @return list of items
     */
    public static <T> List<List<List<T>>> group(final List<T> input,
                                                final List<Integer> collect) {
        final int zero = 0;
        final int one = 1;
        List<List<List<T>>> result = new ArrayList<>();
        if (collect.isEmpty()) {
            List<List<List<T>>> lists = new ArrayList<>();
            lists.add(new ArrayList<>());
            return lists;
        }
        int n = collect.get(zero);
        List<Integer> ns = collect.subList(one, collect.size());
        List<List<T>> combinations = P26.combinations(input, n);
        combinations.forEach(c -> {
            List<T> remaining = remaining(input, c);
            group(remaining, ns).forEach(cg -> {
                List<List<T>> sg = new ArrayList<>();
                sg.add(c);
                sg.addAll(cg);
                result.add(sg);
            });
        });
        return result;
    }
}
