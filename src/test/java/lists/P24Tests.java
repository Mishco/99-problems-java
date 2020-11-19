package lists;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class P24Tests {

    @Test
    void shouldGive6RandomNumbersFromARangeStartingFrom1To49() {
        List<Integer> randomList = P24.randomSelect(6, 1, 49);
        assertThat(randomList, hasSize(6));
    }
}
