package arithmetic;

/**
 * Check prime number
 */
public final class P29 {

    private P29() {
    }

    /**
     * A simple, but very inefficient primality test uses Wilson's theorem,
     * which states that p is prime if and only if
     * </p>
     *
     * @param n number for test
     * @return true if prime or not
     */
    public static boolean isPrime(int n) {
        if (n <= 3) {
            return n > 1;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        int i = 5;

        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
            i = i + 6;
        }

        return true;
    }
}
