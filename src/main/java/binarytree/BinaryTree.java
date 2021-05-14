package binarytree;

/**
 * Simple Implementation of Binary Tree
 */
public final class BinaryTree {
    private Node root;

    private static class Node {
        Node left;
        Node right;
        String data;

        Node(String newData) {
            left = null;
            right = null;
            data = newData;
        }
    }

    /**
     * Creates an empty binary tree
     * Return: a null root pointer.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Returns true if the given target is in the binary tree.
     * Uses a recursive helper.
     */
    public boolean lookup(String data) {
        return (lookup(root, data));
    }

    private boolean lookup(Node node, String data) {
        if (node == null) {
            return (false);
        }

        if (data.compareTo(node.data) == 0) {
            return (true);
        } else if (data.compareTo(node.data) < 0) {
            return (lookup(node.left, data));
        } else {
            return (lookup(node.right, data));
        }
    }

    /**
     * Inserts the given data into the binary tree.
     * Uses a recursive helper.
     * Returns in any case, return the new pointer to the caller
     */
    public void insert(String data) {
        root = insert(root, data);
    }

    private Node insert(Node node, String data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data.compareTo(node.data) < 0) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return (node);
    }


    /**
     * Returns element if the given target is in the binary tree.
     * Uses a recursive helper.
     */
    public String find(String data) {
        return (find(root, data));
    }

    private String find(Node node, String data) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.data) == 0) {
            return data;
        } else if (data.compareTo(node.data) < 0) {
            return (find(node.left, data));
        } else {
            return (find(node.right, data));
        }
    }

}
