package lists;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class P17Tests {

    @Test
    void shouldSplitInTwoHalves() {
        Map<Boolean, List<String>> result = P17.split(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3);
        assertThat(result.get(true), contains("a", "b", "c"));
        assertThat(result.get(false), contains("d", "e", "f", "g", "h", "i", "k"));
    }

}
