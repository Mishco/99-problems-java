package lists;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;


public class P21Tests {

    @Test
    public void shouldInsertElementAtSecondPosition() throws Exception {
        List<String> input = Stream.of("a", "b", "c", "d").collect(toList());
        List<String> result = P21.insertAt(input, 2, "alfa");
        assertThat(result, hasSize(5));
        assertThat(result, contains("a", "alfa", "b", "c", "d"));

    }

    @Test
    public void shouldInsertElementAtFirstPosition() throws Exception {
        List<String> input = Stream.of("a", "b", "c", "d").collect(toList());
        List<String> result = P21.insertAt(input, 1, "alfa");
        assertThat(result, hasSize(5));
        assertThat(result, contains("alfa", "a", "b", "c", "d"));

    }

    @Test
    public void shouldInsertElementAtEnd() throws Exception {
        List<String> input = Stream.of("a", "b", "c", "d").collect(toList());
        List<String> result = P21.insertAt(input, 5, "alfa");
        assertThat(result, hasSize(5));
        assertThat(result, contains("a", "b", "c", "d", "alfa"));
    }
}
