package arithmetic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

class P33Test {

    @Test
    public void _8_isthesumof_3_and_5() {
        List<Integer> numbers = P33.goldbach(8);
        assertThat(numbers, hasSize(2));
        assertThat(numbers, hasItems(3, 5));
    }

    @Test
    public void _28_isthesumof_5_and_23() {
        List<Integer> numbers = P33.goldbach(28);
        assertThat(numbers, hasSize(2));
        assertThat(numbers, hasItems(5, 23));
    }
}