package binarytree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class P46Test {

    private void insert(AVLTree tree, Integer... integers) {
        for (Integer i : integers)
            tree.root = tree.insert(tree.root, i);
    }

    @Test
    void testFalseTree() {
        final AVLTree tree = new AVLTree();

        insert(tree, 10, 20, 30, 40, 50, 25);

        final var result = P46.createBalancedTree(tree);

        assertNotNull(result);
    }

}