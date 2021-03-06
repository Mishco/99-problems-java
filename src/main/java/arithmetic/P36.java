package arithmetic;

import java.math.BigInteger;

public final class P36 {

    private P36() {
    }

    /**
     * Two numbers are coprime if their greatest common divisor equals 1.
     * gcd(n**a - 1, n**b -1) = n**gcd(a,b) - 1
     *
     * @param firstNumber  A - number
     * @param secondNumber B - number
     * @return true if comprine, false otherwise
     */
    public static boolean coprime(final int firstNumber,
                                  final int secondNumber) {
        return P35.gcd(
                firstNumber,
                secondNumber) == BigInteger.ONE.intValue();
    }

}
