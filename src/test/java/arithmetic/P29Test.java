package arithmetic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class P29Test {

    @Test
    public void shouldSay7IsAPrimeNumber() {
        boolean prime = P29.isPrime(7);
        assertTrue(prime);
    }

    @Test
    public void shouldSay10IsNotAPrimeNumber() {
        boolean prime = P29.isPrime(10);
        assertFalse(prime);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29})
    public void firstTenPrimeNumbers(int n) {
        assertTrue(P29.isPrime(n));
    }
}
