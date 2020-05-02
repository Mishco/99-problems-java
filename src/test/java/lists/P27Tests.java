package lists;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;


public class P27Tests {

    @Test
    public void shouldGroupIntoThreeGroupsOfSize_2_3_and_4() {
        List<String> input = Stream.of("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida").collect(toList());
        List<List<List<String>>> groups = P27.group3(input);
        assertThat(groups, hasSize(1260));
    }

    @Test
    public void shouldGroupIntoThreeGroupsOfSize_2_2_and_5() {
        List<String> input = Stream.of("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida").collect(toList());
        List<List<List<String>>> groups = P27.group(input, Stream.of(2, 2, 5).collect(Collectors.toList()));
        assertThat(groups, hasSize(756));
    }

}

