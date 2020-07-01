package arithmetic;

import lists.P10;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.stream.Collectors;

final class P31 {

    private P31() {
    }

    /**
     * Determine the prime factors of a given positive integer (2).
     *
     * @param input number
     * @return prime factors separated by SimpleEntry
     */
    public static List<SimpleEntry<Integer, Integer>> primeFactorsMult(
            final int input) {
        final List<Integer> primeFactors = P30.primeFactors(input);
        return P10.encode(primeFactors)
                .stream()
                .map(item -> new SimpleEntry<>(item.getValue(), item.getKey()))
                .collect(Collectors.toList());
    }
}
