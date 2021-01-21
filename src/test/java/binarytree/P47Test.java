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

    @Test
    void testSimpleTree() {
        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 3);

        assertTrue(P47.isSymmetricTree(tree));
    }

    @Test
    void testAsymmetricSimpleTree() {
        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 4);

        assertFalse(P47.isSymmetricTree(tree));
    }

    @Test
    void testAsymmetricSimpleTreeSecond() {
        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 2);

        assertFalse(P47.isSymmetricTree(tree));
    }


    @Test
    void testAsymmetricSimpleTreeThird() {
        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 4);

        assertFalse(P47.isSymmetricTree(tree));
    }
}
