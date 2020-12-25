package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public final class P45 {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    private P45() {
    }

    /**
     * Cases:
     * * An empty tree is complete Binary Tree
     * * Check left node
     * * Check right nodes
     * * If this a non-full node, set the flag as true
     *
     * @param root input tree
     * @return true if that is binary tree, false otherwise.
     */
    public static boolean isTree(Node root) {
        if (root == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        boolean flag = false;

        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.remove();

            if (tempNode.left != null) {
                if (flag)
                    return false;

                queue.add(tempNode.left);
            } else
                flag = true;

            if (tempNode.right != null) {
                if (flag)
                    return false;
                queue.add(tempNode.right);
            } else
                flag = true;
        }
        return true;
    }
}
