package binarytree;


public final class P47 {

    private P47() {
    }

    //4.03 (**) Symmetric binary trees

    /**
     * Symmetric definition:
     * * The two root nodes have the same value
     * * The left subtree of one root node is a mirror reflection
     * of the right subtree of the other root node
     */
    public static boolean isSymmetricTree(AVLTree root) {
        if (root.isEmpty()) {
            return true;
        }
        return isMirror(root.root.left, root.root.right);
    }

    private static boolean isMirror(AVLTree.BVSNode root1, AVLTree.BVSNode root2) {
        if (root1.height == 0 && root2.height == 0) {
            return true;
        } else if (root1.height == 0 || root2.height == 0) {
            return false;
        } else {
            // If you interest if content is also symmetric
            // root1.data == root2.data &&
            return isMirror(root1.left, root2.right) &&
                    isMirror(root1.right, root2.left);
        }
    }

}
