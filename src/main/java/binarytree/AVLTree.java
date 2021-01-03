package binarytree;

import java.util.ArrayList;
import java.util.List;

public final class AVLTree {

    BVSNode root;
    private final List<Integer> inorder = new ArrayList<>();

    int height(BVSNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    BVSNode rotateRight(BVSNode y) {
        BVSNode x = y.left;
        BVSNode t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    BVSNode rotateLeft(BVSNode x) {
        BVSNode y = x.right;
        BVSNode t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalance(BVSNode node) {
        if (node == null)
            return 0;

        return height(node.left) - height(node.right);
    }

    public BVSNode insert(BVSNode node, int key) {
        if (node == null) {
            return new BVSNode(key);
        }
        if (key < node.data) {
            node.left = insert(node.left, key);
        } else if (key > node.data) {
            node.right = insert(node.right, key);
        } else {
            // duplicate not allowed
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.data) {
            return rotateRight(node);
        }
        if (balance < -1 && key > node.right.data) {
            return rotateLeft(node);
        }
        if (balance > 1 && key > node.left.data) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && key < node.right.data) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }


    void printInorder(BVSNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        inorder.add(node.data);
        printInorder(node.right);
    }

    public List<Integer> getPrintInorder(BVSNode root) {
        printInorder(root);
        return inorder;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public void removeAllNodes() {
        root = null;
    }

    static class BVSNode {
        int data;
        int height;
        BVSNode left;
        BVSNode right;

        BVSNode(int d) {
            data = d;
            height = 1;
            left = null;
            right = null;
        }
    }
}
