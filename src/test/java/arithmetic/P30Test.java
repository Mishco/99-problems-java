package arithmetic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;


class P30Test {

    @Test
    public void shouldFindPrimeFactorsOf315() {
        List<Integer> primeFactors = P30.primeFactors(315);
        assertThat(primeFactors, hasItems(3, 3, 5, 7));
    }

    @Test
    public void shouldFindPrimeFactorsOf33() {
        List<Integer> primeFactors = P30.primeFactors(33);
        assertThat(primeFactors, hasItems(3, 11));
    }

}