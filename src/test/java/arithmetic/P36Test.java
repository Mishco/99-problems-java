package arithmetic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P36Test {

    @Test
    void shouldSay35And64IsCoprime() {
        boolean coprime = P36.coprime(35, 64);
        assertTrue(coprime);
    }

    @Test
    void shouldSay4And9IsCoprime() {
        assertTrue(P36.coprime(4, 9));
    }

    @Test
    void shouldSay13And31sCoprime() {
        assertTrue(P36.coprime(13, 31));
    }

    @Test
    void shouldSay18and35sCoprime() {
        assertTrue(P36.coprime(18, 35));
    }
}