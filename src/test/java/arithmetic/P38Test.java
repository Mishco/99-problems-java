package arithmetic;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class P38Test {
    @Test
    void phiOf10Is4() {
        int p = P38.phi(10);
        assertThat(p, equalTo(4));
    }

    @Test
    void phiOf99Is60() {
        int p = P38.phi(99);
        assertThat(p, equalTo(60));
    }
}