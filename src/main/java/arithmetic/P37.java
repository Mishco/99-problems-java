package arithmetic;

import java.math.BigInteger;
import java.util.stream.IntStream;

public final class P37 {


    private P37() {
    }

    /**
     * Euler's so-called totient function phi(m) is defined as.
     * the number of positive integers
     * r (1 <= r < m) that are coprime to m.
     *
     * @param input m - number
     * @return Long range
     */
    public static Long phi(int input) {
        final BigInteger integerInput = BigInteger.valueOf(input);
        return IntStream.rangeClosed(1, integerInput.intValue())
                .filter(r -> P36.coprime(r, integerInput.intValue()))
                .count();
    }
}
