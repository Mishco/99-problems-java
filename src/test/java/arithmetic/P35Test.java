package arithmetic;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class P35Test {

    @Test
    void gcdOf36And63Is9() {
        int gcd = P35.gcd(36, 63);
        assertThat(gcd, equalTo(9));
    }

    @Test
    void gcdOfNumber20and30() {
        int gcd = P35.gcd(20, 30);
        assertEquals(10, gcd);
    }

    @Test
    void gcdOfNumber270and192() {
        int gcd = P35.gcd(270, 192);
        assertEquals(6, gcd);
    }

}