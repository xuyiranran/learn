package learn_training.binary_tree;

import lombok.Data;


/**
 * 设计到二叉树的算法题目,大概率是离不开递归的。
 * <p>
 * 需要深入理解和掌握递归技巧
 */
@Data
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

}
