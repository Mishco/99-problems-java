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
    void shouldFindLastElementFromAListOfAlphabets() {
        assertThat(P01.last(asList("a", "b", "c", "d")), is(equalTo("d")));
    }

    @Test
    void shouldFindSecondLastElementFromAList() {
        List<Integer> numbers = asList(1, 2, 11, 4, 5, 8, 10, 6);
        assertThat(P02.secondLast(numbers), is(equalTo(10)));
    }

    @Test
    void shouldFindSecondLastElementFromAnotherList() {
        LinkedList<Integer> numbers = new LinkedList<>(asList(1, 2, 11, 4, 5, 8, 10, 6));
        assertThat(P02.secondLast(numbers), is(equalTo(10)));
    }

    @Test
    void shouldThrowExceptionWhenListEmpty() {
        final List<Integer> emptyList = Collections.emptyList();
        Assertions.assertThrows(NoSuchElementException.class, () -> P02.secondLast(emptyList));
    }

    @Test
    void shouldThrowExceptionWhenListHasSingleElement() {
        final List<Integer> singletonList = Collections.singletonList(1);
        Assertions.assertThrows(NoSuchElementException.class, () -> P02.secondLast(singletonList));
    }

    @Test
    void shouldFindKthElementFromAList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(P03.kth(numbers, 2), is(equalTo(3)));
    }

    @Test
    void shouldThrowExceptionWhenKthListIsEmpty() {
        final List<Integer> emptyList = Collections.emptyList();
        Assertions.assertThrows(NoSuchElementException.class, () -> P03.kth(emptyList, 1));
    }

    @Test
    void shouldThrowExceptionWhenKthIsInvalid() {
        final var singletonList = Collections.singletonList(1);
        Assertions.assertThrows(NoSuchElementException.class, () -> P03.kth(singletonList, -1));
    }

    @Test
    void listOfEmptyListShouldBe0() {
        int length = P04.length(Collections.emptyList());
        assertThat(length, is(equalTo(0)));
    }

    @Test
    void shouldFindListOfNonEmptyList() {
        assertThat(P04.length(Arrays.asList(1, 2, 3, 4, 5)), is(equalTo(5)));
    }

    @Test
    void shouldReverseAList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(P05.reverse(numbers), is(equalTo(Arrays.asList(5, 4, 3, 2, 1))));
    }

    @Test
    void shouldReturnTrueWhenListIsPalindrome() {
        assertTrue(P06.isPalindrome(Arrays.asList("x", "a", "m", "a", "x")));
    }

    @Test
    void shouldReturnFalseWhenListIsNotPalindrome() {
        assertFalse(P06.isPalindrome(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    void shouldFlattenAListOfList() {
        List<String> flatten = P07.flatten(asList("a", asList("b", asList("c", "d")), "e"));
        assertThat(flatten, hasSize(5));
        assertThat(flatten, hasItems("a", "b", "c", "d", "e"));
    }

    @Test
    void shouldFlattenDeepNestedLists() {
        List<String> flatten = P07.flatten(asList("a", asList("b", asList("c", asList("d", "e", asList("f", "g"))), "h")));
        assertThat(flatten, hasSize(8));
        assertThat(flatten, hasItems("a", "b", "c", "d", "e", "f", "g", "h"));
    }

    @Test
    void shouldReturnEmptyListWhenTryingToFlattenAnEmptyList() {
        List<String> flatten = P07.flatten(Collections.emptyList());
        assertTrue(flatten.isEmpty());
    }
}