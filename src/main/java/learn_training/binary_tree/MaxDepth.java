package learn_training.binary_tree;


/**
 * leetcode 104:maximum depth of binary tree
 * <p>
 * 二叉树的最大深度
 */
public class MaxDepth {


    int max = 0;

    public int maxDepth(TreeNode root) {

        if (root == null) return 0;

        return max(root, max);
    }

    private int max(TreeNode node, int max) {

        if (node == null) return max;
        int left = max(node.left, max + 1);
        int right = max(node.right, max + 1);
        max = Math.max(left, right);
        return max;

    }


}
