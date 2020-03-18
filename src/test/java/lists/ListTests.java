package lists;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class ListTests {

    @Test
    public void shouldFindLastElementFromAListOfAlphabets() {
        assertThat(P01.last(asList("a", "b", "c", "d")), is(equalTo("d")));
    }
}