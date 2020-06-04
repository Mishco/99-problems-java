package arithmetic;

/**
 * Check prime number.
 */
public final class P29 {

    public static final int ONE = 1;
    public static final int FIRST_PRIME = 2;
    public static final int SECOND_PRIME = 3;
    public static final int THIRD_PRIME = 5;
    public static final int GAP = 6;

    private P29() {
    }

    /**
     * A simple, but very inefficient primality test uses Wilson's theorem,
     * which states that p is prime if and only if.
     *
     * @param n number for test
     * @return true if prime or not
     */
    public static boolean isPrime(int n) {
        if (n <= SECOND_PRIME) {
            return n > ONE;
        } else if (n % FIRST_PRIME == 0 || n % SECOND_PRIME == 0) {
            return false;
        }
        int i = THIRD_PRIME;

        while (i * i <= n) {
            if (n % i == 0 || n % (i + FIRST_PRIME) == 0) {
                return false;
            }
            i = i + GAP;
        }
        return true;
    }
}
