package lists;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;

public class P25Tests {

    @Test
    public void shouldGenerateRandomPermutationOfElementsOfAList()  {
        List<String> permutation = P25.randomPermutation(Stream.of("a", "b", "c", "d", "e", "f").collect(toList()));
        assertThat(permutation, hasSize(6));
        assertThat(permutation, containsInAnyOrder("a", "b", "c", "d", "e", "f"));
        System.out.println(permutation); // one possible output [a, e, f, c, b, d]
    }
}
