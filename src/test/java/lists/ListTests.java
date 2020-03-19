package lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class ListTests {

    @Test
    public void shouldFindLastElementFromAListOfAlphabets() {
        assertThat(P01.last(asList("a", "b", "c", "d")), is(equalTo("d")));
    }

    @Test
    public void shouldFindSecondLastElementFromAList() {
        List<Integer> numbers = asList(1, 2, 11, 4, 5, 8, 10, 6);
        assertThat(P02.secondLast(numbers), is(equalTo(10)));
    }

    @Test
    public void shouldFindSecondLastElementFromAnotherList() {
        LinkedList<Integer> numbers = new LinkedList<>(asList(1, 2, 11, 4, 5, 8, 10, 6));
        assertThat(P02.secondLast(numbers), is(equalTo(10)));
    }

    @Test
    public void shouldThrowExceptionWhenListEmpty() {
        Assertions.assertThrows(NoSuchElementException.class, () -> P02.secondLast(Collections.emptyList()));
    }

    @Test
    public void shouldThrowExceptionWhenListHasSingleElement() {
        Assertions.assertThrows(NoSuchElementException.class, () -> P02.secondLast(Collections.singletonList(1)));
    }

    @Test
    public void shouldFindKthElementFromAList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(P03.kth(numbers, 2), is(equalTo(3)));
    }

    @Test
    public void shouldThrowExceptionWhenKthListIsEmpty() {
        Assertions.assertThrows(NoSuchElementException.class, () -> P03.kth(Collections.emptyList(), 1));
    }

    @Test
    public void shouldThrowExceptionWhenKthIsInvalid() {
        Assertions.assertThrows(NoSuchElementException.class, () -> P03.kth(Collections.singletonList(1), -1));
    }
}