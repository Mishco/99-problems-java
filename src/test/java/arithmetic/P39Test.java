package arithmetic;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class P39Test {

    @Test
    void shouldCalculatePhiOf10090UsingP39()  {
        long p = P37.phi(10090);
        assertThat(p, equalTo(4032L));
    }

    @Test
    void shouldCalculatePhiOf10090UsingP40()  {
        long p = P38.phi(10090);
        assertThat(p, equalTo(4032L));
    }

    @Test
    void shouldReturnTheSameResult() {
        long p1 = P38.phi(10090);
        long p2 = P37.phi(10090);
        assertEquals(p1, p2);
    }
}