package arithmetic;

import java.util.ArrayList;
import java.util.List;

public final class P30 {

    private P30() {
    }

    /**
     * Determine the prime factors of a given positive integer.
     *
     * @param input input number
     * @return flat list containing the prime factors in ascending order.
     */
    public static List<Integer> primeFactors(final int input) {
        final var firstPrime = 2;
        List<Integer> res = new ArrayList<>();

        for (int currPrimeNumber = firstPrime;
             currPrimeNumber <= (input / firstPrime);
             currPrimeNumber++) {
            if (P29.isPrime(currPrimeNumber)) {
                int val = input;
                while (val % currPrimeNumber == 0) {
                    res.add(currPrimeNumber);
                    val = val / currPrimeNumber;
                }
            }
        }

        return res;
    }
}
