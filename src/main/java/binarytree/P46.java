package binarytree;

import java.util.List;

public final class P46 {

    private P46() {

    }

    public static AVLTree createBalancedTree(AVLTree tree) {
        if (tree.isEmpty()) {
            return null;
        }
        List<Integer> inorder = tree.getPrintInorder(tree.root);
        return tree;
    }
}
