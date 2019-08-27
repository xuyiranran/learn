package learn_training.binary_tree;

/**
 * leetcode 101:symmetric tree
 * <p>
 * 对称树判断
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }


    /**
     * @param t1
     * @param t2
     * @return
     */
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

}
