package lists;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class P12Tests {

    @Test
    void shouldDecodeEncodedList() {
        List<String> encoded = P12.decode(
                Arrays.asList(
                        new SimpleEntry<>(4, "a"),
                        "b",
                        new SimpleEntry<>(2, "c"),
                        new SimpleEntry<>(2, "a"),
                        "d",
                        new SimpleEntry<>(4, "e")));

        assertThat(encoded, hasSize(14));
    }


}
