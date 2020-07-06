package arithmetic;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class P37Test {

    @Test
    void shouldSayPhiOf10Is4()  {
        long phi = P37.phi(10);
        assertThat(phi, equalTo(4L));
    }

}