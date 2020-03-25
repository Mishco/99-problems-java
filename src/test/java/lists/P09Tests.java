package lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class P09Tests {

    @Test
    public void shouldReturnAListWithTwoListElementsWhenAListWithTwoUniqueElementsIsPassed() {
        List<List<String>> packedList = P09.pack(Arrays.asList("a", "b"));
        assertThat(packedList, hasSize(2));
        assertThat(packedList.get(0), contains("a"));
        assertThat(packedList.get(1), contains("b"));
    }

    @Test
    public void shouldPackConsecutiveDuplicatesInTheirOwnLists() {
        List<List<String>> packedList = P09.pack(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
        assertThat(packedList, hasSize(6));
        assertThat(packedList.get(0), contains("a", "a", "a", "a"));
        assertThat(packedList.get(1), contains("b"));
        assertThat(packedList.get(2), contains("c", "c"));
        assertThat(packedList.get(3), contains("a", "a"));
        assertThat(packedList.get(4), contains("d"));
        assertThat(packedList.get(5), contains("e", "e", "e", "e"));
    }

    @Test
    public void shouldThrowNull() {
        Assertions.assertThrows(NullPointerException.class, () -> P09.pack(null));
    }

    @Test
    public void shouldNotBeEmpty() {
        assertTrue(P09.pack(Collections.emptyList()).isEmpty());
    }
}
