package lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class P20Tests {

    @Test
    public void shouldRemoveKthElementFromList() {
        Object[] result = P20.removeAt(Arrays.asList("a", "b", "c", "d"), 2);
        assertThat(result[0], equalTo(Arrays.asList("a", "c", "d")));
        assertThat(result[1], equalTo("b"));
    }


    @Test
    public void shouldThrowException() {
        Assertions.assertThrows(NoSuchElementException.class, () -> P20.removeAt(Collections.emptyList(), 2));
    }
}
