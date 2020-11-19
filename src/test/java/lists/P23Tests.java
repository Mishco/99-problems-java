package lists;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;


class P23Tests {

    @RepeatedTest(10)
    void shouldReturnAListOfThreeRandomSelectedElements() {
        List<String> result = P23.randomSelect(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 3);
        assertThat(result, hasSize(3));
    }
}
