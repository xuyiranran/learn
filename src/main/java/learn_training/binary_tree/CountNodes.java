package learn_training.binary_tree;

import java.util.Stack;

/**
 * leetcode 222:count complete tree nodes
 * <p>
 * 统计完全二叉树的节点数
 *
 * TODO
 */
public class CountNodes {


    public int countNodes(TreeNode root) {

        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        stack.push(root);
        while (!stack.isEmpty()) {
            count++;
            TreeNode node = stack.pop();
            if (node.left == null) {
                return 2 * count - 1;
            }
            if (node.right == null) {
                return 2 * count;
            }
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }
        return count;
    }


}
