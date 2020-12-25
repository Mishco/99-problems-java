package binarytree;

import org.junit.jupiter.api.Test;

import static binarytree.P45.Node;
import static binarytree.P45.isTree;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class P45Test {


    @Test
    void testFalseTree() {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        final var result = isTree(root);

        assertFalse(result);
    }

    @Test
    void testTreeWithOneNode() {
        Node root = new Node(0);
        assertTrue(isTree(root));
    }

    @Test
    void testTreeNull() {
        Node root = null;
        assertTrue(isTree(root));
    }
}