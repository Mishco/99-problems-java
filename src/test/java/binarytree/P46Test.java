package binarytree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class P46Test {

    @Test
    void testBasicTree() {
        final var result = P46.createBalancedTree(6, 10, 20, 30, 40, 50, 25);
        assertNotNull(result);
    }


    @Test
    void testInvalidTree() {
        Assertions.assertThrows(NoSuchElementException.class,
                () -> P46.createBalancedTree(0, 0));
    }

    @Test
    void testNullTree() {
        Assertions.assertNull(P46.createBalancedTree(0, null));
    }
}