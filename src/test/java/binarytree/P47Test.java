package binarytree;

import org.junit.jupiter.api.Test;

import static binarytree.P45.isTree;
import static org.junit.jupiter.api.Assertions.*;

class P47Test {

    @Test
    void testBasicTree() {
        AVLTree tree = new AVLTree();
        assertTrue(P47.isSymmetricTree(tree));
    }

    @Test
    void testOneItemTree() {
        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 1);

        assertTrue(P47.isSymmetricTree(tree));
    }
}
