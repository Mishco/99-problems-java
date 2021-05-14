package binarytree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryTreeTest {

    @Test
    void testEmptyTree() {
        BinaryTree emptyTree = new BinaryTree();
        assertNotNull(emptyTree);
    }

    @Test
    void build123Tree() {
        BinaryTree root = new BinaryTree();
        root.insert("1");
        root.insert("2");
        root.insert("3");
        assertTrue(root.lookup("2"));
    }

    @Test
    void build321Tree() {
        BinaryTree root = new BinaryTree();
        root.insert("3");
        root.insert("2");
        root.insert("1");
        assertTrue(root.lookup("3"));
    }

}