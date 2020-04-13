package lists;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;

public class P16Tests {

    @Test
    public void shouldDropEveryNthElement() {
        List<String> result = P16.dropEveryNth(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 3);
        assertThat(result, hasSize(8));
        assertThat(result, contains("a", "b", "d", "e", "g", "h", "j", "k"));
    }

    @Test
    public void shouldReturnSameListWhenNIsLessThanListSize() {
        List<String> result = P16.dropEveryNth(Arrays.asList("a", "b"), 3);
        assertThat(result, hasSize(2));
        assertThat(result, contains("a", "b"));
    }

    @Test
    public void shouldReturnSameListWhenNIsZero() {
        List<String> result = P16.dropEveryNth(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 0);
        assertThat(result, hasSize(11));
        assertThat(result, contains("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"));
    }
}
