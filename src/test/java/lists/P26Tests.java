package lists;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;


class P26Tests {
    @Test
    void shouldFindAllCombinationsOfSize3FromAListWithSize6() {
        List<String> input = Stream.of("a", "b", "c", "d", "e", "f").collect(toList());
        List<List<String>> combinations = P26.combinations(input, 3);
        assertThat(combinations, hasSize(20));
    }

    @Test
    void shouldReturnEmptyList() {
        List<List<Object>> input = P26.combinations(Collections.emptyList(), 0);
        assertTrue(input.isEmpty());
    }
}
