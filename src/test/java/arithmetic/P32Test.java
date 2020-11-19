package arithmetic;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.MatcherAssert.assertThat;

class P32Test {


    @Test
    void shouldGiveAllPrimeNumbersBetween2And10() {
        List<Integer> primeNumbers = P32.primeNumbers(IntStream.rangeClosed(2, 10));
        assertThat(primeNumbers, hasSize(4));
        assertThat(primeNumbers, hasItems(2, 3, 5, 7));
    }

    @Test
    void shouldGiveAllPrimeNumbersBetween7And31() {
        List<Integer> primeNumbers = P32.primeNumbers(IntStream.rangeClosed(7, 31));
        assertThat(primeNumbers, hasSize(8));
        assertThat(primeNumbers, hasItems(7, 11, 13, 17, 19, 23, 29, 31));
    }
}