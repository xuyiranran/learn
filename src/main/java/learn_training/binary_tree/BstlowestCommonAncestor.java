package learn_training.binary_tree;

public class BstlowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        if (root == null) return null;
        int parentVal = root.val;
        int pval = p.val;
        int qval = q.val;
        //都小于当前根节点
        if (parentVal > pval && parentVal > qval) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (parentVal < pval && parentVal < qval) {
            //都大于当前根节点
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }


}
