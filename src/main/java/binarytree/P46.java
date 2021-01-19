package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public final class P46 {

    private P46() {

    }

    public static Queue<binarytree.P45.Node> createBalancedTree(AVLTree tree) {
        if (tree.isEmpty()) {
            return new List<Integer>();
        }            
        List<Integer> inorder = tree.getPrintInorder(tree.root);
        return tree;
    }
}
