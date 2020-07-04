package arithmetic;

public final class P35 {

    private P35() {

    }

    /**
     * Determine the greatest common divisor of two positive integer numbers.
     *
     * @param firstNumber  first number
     * @param secondNumber second number
     * @return greatest common divisor of input numbers.
     */
    public static int gcd(final int firstNumber,
                          final int secondNumber) {
        int a = firstNumber;
        int b = secondNumber;
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }


}
