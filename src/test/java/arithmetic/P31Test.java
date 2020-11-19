package arithmetic;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import static org.junit.Assert.assertEquals;

class P31Test {

    @Test
    void shouldFindPrimeFactorsOf315() {
        List<SimpleEntry<Integer, Integer>> primeFactors = P31.primeFactorsMult(315);
        List<SimpleEntry<Integer, Integer>> shouldBe = List.of(new SimpleEntry<>(3, 2), new SimpleEntry<>(5, 1), new SimpleEntry<>(7, 1));
        assertEquals(primeFactors, shouldBe);
    }

    @Test
    void shouldFindPrimeFactorsOf33() {
        List<SimpleEntry<Integer, Integer>> primeFactors = P31.primeFactorsMult(33);
        List<SimpleEntry<Integer, Integer>> shouldBe = List.of(new SimpleEntry<>(3, 1), new SimpleEntry<>(11, 1));
        assertEquals(primeFactors, shouldBe);
    }
}