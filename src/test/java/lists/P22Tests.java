package lists;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;


class P22Tests {

    @Test
    void shouldCreateARangeBetween4And9() {
        List<Integer> range = P22.range(4, 9);
        assertThat(range, hasSize(6));
        assertThat(range, contains(4, 5, 6, 7, 8, 9));
    }

}
