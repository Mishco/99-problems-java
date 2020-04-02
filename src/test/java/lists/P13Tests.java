package lists;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;


public class P13Tests {

    @Test
    public void shouldEncodeAList() {
        List<SimpleEntry<Integer, String>> encodedList = P13.encode_direct(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
        assertThat(encodedList, hasSize(6));
        assertThat(encodedList.get(0), is(equalTo(new SimpleEntry<>(4, "a"))));
        assertThat(encodedList.get(1), is(equalTo(new SimpleEntry<>(1, "b"))));
        assertThat(encodedList.get(2), is(equalTo(new SimpleEntry<>(2, "c"))));
        assertThat(encodedList.get(3), is(equalTo(new SimpleEntry<>(2, "a"))));
        assertThat(encodedList.get(4), is(equalTo(new SimpleEntry<>(1, "d"))));
        assertThat(encodedList.get(5), is(equalTo(new SimpleEntry<>(4, "e"))));
    }

}
