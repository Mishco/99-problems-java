package arithmetic;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.MatcherAssert.assertThat;

class P34Test {

    @Test
    void shouldProduceAListOfGoldbachCompositions() {
        List<AbstractMap.SimpleEntry<Integer, List<Integer>>> compositions = P34.goldbachList(IntStream.rangeClosed(9, 20));
        assertThat(compositions, hasSize(6));
        assertThat(compositions, hasItems(
                new AbstractMap.SimpleEntry<>(10, Arrays.asList(3, 7)),
                new AbstractMap.SimpleEntry<>(12, Arrays.asList(5, 7)),
                new AbstractMap.SimpleEntry<>(14, Arrays.asList(3, 11)),
                new AbstractMap.SimpleEntry<>(16, Arrays.asList(3, 13)),
                new AbstractMap.SimpleEntry<>(18, Arrays.asList(5, 13)),
                new AbstractMap.SimpleEntry<>(20, Arrays.asList(3, 17))
        ));
    }

    @Test
    void shouldProduceAListOfGoldbachCompositionsWhereBothPrimeNumbersAreGreaterThan50() {
        List<AbstractMap.SimpleEntry<Integer, List<Integer>>> compositions = P34.goldbachInterval(IntStream.rangeClosed(1, 2000), 50);
        assertThat(compositions, hasSize(4));
        assertThat(compositions, hasItems(
                new AbstractMap.SimpleEntry<>(992, Arrays.asList(73, 919)),
                new AbstractMap.SimpleEntry<>(1382, Arrays.asList(61, 1321)),
                new AbstractMap.SimpleEntry<>(1856, Arrays.asList(67, 1789)),
                new AbstractMap.SimpleEntry<>(1928, Arrays.asList(61, 1867))
        ));
    }
    @Test
    void shouldGoldbachCompositionsGreaterThan1() {
        List<AbstractMap.SimpleEntry<Integer, List<Integer>>> compositions = P34.goldbachInterval(IntStream.rangeClosed(1, 100), 1);
        assertThat(compositions, hasSize(49));
    }
    @Test
    void shouldGoldbachCompositionsGreaterThan100() {
        List<AbstractMap.SimpleEntry<Integer, List<Integer>>> compositions = P34.goldbachInterval(IntStream.rangeClosed(1, 100), 18);
        assertThat(compositions, hasSize(1));
    }
}