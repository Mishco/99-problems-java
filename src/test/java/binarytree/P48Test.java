package binarytree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P48Test {

    @Test
    void testBasicTree() {
        var result = P48.binarySearchTreesDictionary("key1");
        assertNotNull(result);
    }

}