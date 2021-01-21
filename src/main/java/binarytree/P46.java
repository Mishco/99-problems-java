package binarytree;

import java.util.NoSuchElementException;

public final class P46 {

    private P46() {

    }


    /**
     * Create balanced tree.
     * cbal_tree(4,T)
     * Insert all items into AVL (Binary balanced tree).
     *
     * @param countNodes number of nodes
     * @param integers   items
     * @return avl tree (balanced tree)
     */
    public static AVLTree createBalancedTree(Integer countNodes, Integer... integers) {
        AVLTree tree = new AVLTree();
        if (integers == null) {
            return null;
        }
        if (countNodes <= 0 || integers.length <= 0) {
            throw new NoSuchElementException("Nodes items is empty");
        }
        for (Integer i : integers)
            tree.root = tree.insert(tree.root, i);

        return tree;
    }
}
