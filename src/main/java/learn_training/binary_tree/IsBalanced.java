package learn_training.binary_tree;

/**
 * leetcode 110:balanced binary tree
 * <p>
 * 平衡二叉树判断
 */
public class IsBalanced {


    boolean balance = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        help(root);
        return balance;
    }

    private int help(TreeNode node) {
        if (node == null) return 0;
        int left = help(node.left) + 1;
        int right = help(node.right) + 1;
        if (Math.abs(left - right) > 1) balance = false;
        return Math.max(left, right);
    }


}
