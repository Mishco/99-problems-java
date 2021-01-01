package binarytree;

import org.junit.jupiter.api.Test;

import static binarytree.P45.isTree;
import static org.junit.jupiter.api.Assertions.*;

class P46Test {


    @Test
    void testFalseTree() {

        P45.Node root = new P45.Node(1);
        root.left = new P45.Node(2);
        root.right = new P45.Node(3);
        root.left.left = new P45.Node(4);
        root.left.right = new P45.Node(5);
        root.right.right = new P45.Node(6);
        final var result = P46.createBalancedTree();

        assertNotNull(result);
    }

}