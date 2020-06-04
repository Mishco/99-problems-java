package arithmetic;

import org.junit.jupiter.api.Test;

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

}