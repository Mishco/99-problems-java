package lists;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class P24Tests {
    @Test
    public void shouldGive6RandomNumbersFromARangeStartingFrom1To49() {
        List<Integer> randomList = P24.randomSelect(6, 1, 49);
        assertThat(randomList, hasSize(6));
        System.out.println(randomList); // One possible output [47, 30, 36, 38, 11, 1]
    }
}
