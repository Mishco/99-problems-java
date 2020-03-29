package lists;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class P10Tests {

    @Test
    public void shouldEncodeAList()  {
        List<AbstractMap.SimpleEntry<Integer, String>> encodedList = P10.encode(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
        assertThat(encodedList, hasSize(6));
        assertThat(encodedList.get(0), is(equalTo(new AbstractMap.SimpleEntry<>(4, "a"))));
        assertThat(encodedList.get(1), is(equalTo(new AbstractMap.SimpleEntry<>(1, "b"))));
        assertThat(encodedList.get(2), is(equalTo(new AbstractMap.SimpleEntry<>(2, "c"))));
        assertThat(encodedList.get(3), is(equalTo(new AbstractMap.SimpleEntry<>(2, "a"))));
        assertThat(encodedList.get(4), is(equalTo(new AbstractMap.SimpleEntry<>(1, "d"))));
        assertThat(encodedList.get(5), is(equalTo(new AbstractMap.SimpleEntry<>(4, "e"))));
    }
    
    @Test
    public void shouldNotBeEmpty() {
        assertTrue(P10.encode(Collections.emptyList()).isEmpty());
    }
}
