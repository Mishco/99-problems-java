package arithmetic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

final class P32 {

    private P32() {
    }

    /**
     * A list of prime numbers.
     *
     * @param rangeClosed range of number
     * @return list of prime number inside of range
     */
    public static List<Integer> primeNumbers(final IntStream rangeClosed) {
        return rangeClosed.filter(P29::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }
}
