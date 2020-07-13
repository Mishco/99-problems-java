package arithmetic;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class P37Test {

    @Test
    void shouldSayPhiOf10Is4() {
        long phi = P37.phi(10);
        assertThat(phi, equalTo(4L));
    }

}