package arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Goldbach's conjecture.
 * says that every positive even number greater
 * than 2 is the sum of two prime numbers.
 * Example: 28 = 5 + 23.
 * It is one of the most famous facts in number theory
 * that has not been proved to be correct in the general case.
 * It has been numerically confirmed up to very large numbers.
 * Write a predicate to find the two prime numbers
 * that sum up to a given even integer.
 */
public final class P33 {
    private P33() {
    }

    /**
     * Goldbach's conjecture.
     *
     * @param number input number
     * @return list of two prime numbers
     */
    public static List<Integer> goldbach(final int number) {
        ArrayList<Integer> list = new ArrayList<>();
        final var primeList = P32.primeNumbers(IntStream.range(2, number));

        for (int i = 0; i < primeList.size(); i++) {
            final var diff = number - primeList.get(i);
            if (primeList.contains(diff)) {
                list.add(primeList.get(i));
                list.add(diff);
                break;
            }
        }

        return list;
    }
}
