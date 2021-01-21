package binarytree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AVLTreeTest {

    private final AVLTree tree = new AVLTree();
    private void insert(Integer...integers) {
        for(Integer i:integers)
            tree.root = tree.insert(tree.root, i);
    }

    @Test
    void testSimpleAVLTree() {
        assertTrue(tree.isEmpty());

        insert(10, 20, 30, 40, 50, 25);

        List<Integer> inorder = tree.getPrintInorder(tree.root);
        assertArrayEquals(new Integer[]{10, 20, 25, 30, 40, 50}, inorder.toArray());

        tree.removeAllNodes();
    }

    @Test
    void testRemove() {
        assertTrue(tree.isEmpty());
        insert(16,24,36,19,44,28,61,74,83,64,52,65,86,93,88);

        System.out.println(tree.getPrintInorder(tree.root));

    }
}
