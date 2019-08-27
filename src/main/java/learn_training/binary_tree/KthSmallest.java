package learn_training.binary_tree;

/**
 * leetcode 230:kth smallest element in a bst
 * <p>
 * <p>
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素
 * <p>
 * 解题核心思路在于二叉搜索树的中序遍历是有序的
 */
public class KthSmallest {


    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        help(root, k);
        return result;
    }


    private void help(TreeNode node, int k) {
        if (node == null) return;
        help(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
        }
        help(node.right, k);
    }


}
