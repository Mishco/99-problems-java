package lists;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class P18Tests {

    @Test
    public void shouldGiveSliceOfAList() {
        List<String> slice = P18.slice(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3, 7);
        assertThat(slice, hasSize(5));
        assertThat(slice, contains("c", "d", "e", "f", "g"));
    }

    @Test
    public void shouldNotReturnNothingIndexOutOfSize() {
        List<String> slice = P18.slice(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3, -2);
        assertTrue(slice.isEmpty());
    }
}
