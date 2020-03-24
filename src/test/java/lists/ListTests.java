package lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void listOfEmptyListShouldBe0() {
        int length = P04.length(Collections.emptyList());
        assertThat(length, is(equalTo(0)));
    }

    @Test
    public void shouldFindListOfNonEmptyList() {
        assertThat(P04.length(Arrays.asList(1, 2, 3, 4, 5)), is(equalTo(5)));
    }

    @Test
    public void shouldReverseAList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(P05.reverse(numbers), is(equalTo(Arrays.asList(5, 4, 3, 2, 1))));
    }

    @Test
    public void shouldReturnTrueWhenListIsPalindrome() {
        assertTrue(P06.isPalindrome(Arrays.asList("x", "a", "m", "a", "x")));
    }

    @Test
    public void shouldReturnFalseWhenListIsNotPalindrome() {
        assertFalse(P06.isPalindrome(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void shouldFlattenAListOfList() {
        List<String> flatten = P07.flatten(asList("a", asList("b", asList("c", "d")), "e"), String.class);
        assertThat(flatten, hasSize(5));
        assertThat(flatten, hasItems("a", "b", "c", "d", "e"));
    }

    @Test
    public void shouldFlattenDeepNestedLists()  {
        List<String> flatten = P07.flatten(asList("a", asList("b", asList("c", asList("d", "e", asList("f", "g"))), "h")), String.class);
        assertThat(flatten, hasSize(8));
        assertThat(flatten, hasItems("a", "b", "c", "d", "e", "f", "g", "h"));
    }

    @Test
    public void shouldReturnEmptyListWhenTryingToFlattenAnEmptyList()  {
        List<String> flatten = P07.flatten(Collections.emptyList(), String.class);
        assertTrue(flatten.isEmpty());
    }
}