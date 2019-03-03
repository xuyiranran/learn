package leetcode;

/**
 * 二叉树中寻找最大深度
 */
public class MaxDepth {


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return max(root, 1);

    }

    /**
     * 利用递归左右子树
     *
     * @param node
     * @param depth
     * @return
     */
    private int max(TreeNode node, int depth) {
        int left = 0, right = 0;
        if (node.left == null && node.right == null) {
            return depth;
        }
        if (node.right != null) {
            right = max(node.right, depth + 1);
        }
        if (node.left != null) {
            left = max(node.left, depth + 1);
        }
        return left > right ? left : right;
    }

}
