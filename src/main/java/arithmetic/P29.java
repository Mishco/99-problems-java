package arithmetic;

/**
 * Check prime number.
 */
  final class P29 {


    private P29() {
    }

    /**
     * A simple, but very inefficient primality test uses Wilson's theorem,
     * which states that p is prime if and only if.
     *
     * @param n number for test
     * @return true if prime or not
     */
      static boolean isPrime(final int n) {
        final int one = 1;
        final int firstPrime = 2;
        final int secondPrime = 3;
        final int thirdPrime = 5;
        final int gap = 6;

        if (n <= secondPrime) {
            return n > one;
        } else if (n % firstPrime == 0 || n % secondPrime == 0) {
            return false;
        }
        int i = thirdPrime;

        while (i * i <= n) {
            if (n % i == 0 || n % (i + firstPrime) == 0) {
                return false;
            }
            i = i + gap;
        }
        return true;
    }
}
