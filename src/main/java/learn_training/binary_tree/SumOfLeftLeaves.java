package learn_training.binary_tree;

/**
 * leetcode 404:sum of left leaves
 *
 *
 * 计算给定二叉树的所有左叶子之和
 *
 * 核心思想:本题的关键在于如何确定当前节点的左孩子节点是叶子节点了.
 *
 */
public class SumOfLeftLeaves {


    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        help(root);
        return sum;
    }

    private void help(TreeNode node) {
        if (node == null) return;
        //本题的关键在于如何确定当前节点的左孩子节点是叶子节点了.
        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum = sum + node.left.val;
        }
        help(node.left);
        help(node.right);
    }

}
