package learn_training.binary_tree;


/**
 * leetcode 226:invert binary tree
 *
 * 翻转二叉树
 *
 */
public class InvertTree {


    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;
//        if (root.left == null && root.right == null) return root;

        TreeNode right=invertTree(root.right);
        TreeNode left=invertTree(root.left);
        root.left=right;
        root.right=left;
        return root;
    }



}
