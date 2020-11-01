package logiccodes;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class P44HuffmanTest {

    @Test
    void testHuffmanCode(){
        List<SimpleEntry<String,Integer>> frList  = Arrays.asList(
                new SimpleEntry<>("a",45),
                new SimpleEntry<>("b",13),
                new SimpleEntry<>("c",12),
                new SimpleEntry<>("d",16),
                new SimpleEntry<>("e",9),
                new SimpleEntry<>("f",5));
        List<SimpleEntry<String,String>> result =  P44Huffman.huffman(frList);

        assertThat(result, hasSize(6));
        assertThat(result, hasItems(
                new SimpleEntry<>("a","0"),
                new SimpleEntry<>("b","101"),
                new SimpleEntry<>("c","100"),
                new SimpleEntry<>("d","111"),
                new SimpleEntry<>("e","1101"),
                new SimpleEntry<>("f","1100")));

    }
}