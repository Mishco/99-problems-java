package lists;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;


public class P26Tests {
    @Test
    public void shouldFindAllCombinationsOfSize3FromAListWithSize6()  {
        List<String> input = Stream.of("a", "b", "c", "d", "e", "f").collect(toList());
        List<List<String>> combinations = P26.combinations(input, 3);
        assertThat(combinations, hasSize(20));
    }

//    @Test
//    public void shouldFindAllCombinationWithoutRepeating() {
//        List<String> input = Stream.of("a", "b", "c", "d", "e", "f").collect(toList());
//        List<String> combinations = P26.combinationUtil(input, input, 0, input.size() - 1, 0, 3);
//        assertThat(combinations, hasSize(20));
//    }
}
