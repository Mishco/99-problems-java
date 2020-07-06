package arithmetic;

import java.math.BigInteger;

public final class P38 {
    private P38() {

    }

    /**
     * Euler's so-called totient function phi(m) different way.
     *
     * @param input input number
     * @return range result
     */
    public static int phi(final int input) {
        BigInteger bigInteger = BigInteger.valueOf(input);

        return P31.primeFactorsMult(bigInteger.intValue())
                .stream()
                .map(entry -> (entry.getKey() - BigInteger.ONE.intValue())
                        * Math.pow(entry.getKey(),
                        BigInteger.valueOf(entry.getValue())
                                .min(BigInteger.ONE).intValue()))
                .mapToInt(Double::intValue)
                .reduce(1, (i1, i2) -> i1 * i2);
    }
}
