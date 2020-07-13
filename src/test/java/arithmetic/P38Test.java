package arithmetic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P38Test {
    @Test
    void phiOf10Is4() {
        int p = P38.phi(10);
        assertEquals(4, p);
    }

    @Test
    void phiOf99Is60() {
        int p = P38.phi(99);
        assertEquals(60, p);
    }
}