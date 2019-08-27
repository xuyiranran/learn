package learn_training.binary_tree;

/**
 * leetcode 108:convert sorted array to binary serarch tree
 * <p>
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树
 * <p>
 * 关键点就是平衡二叉搜索树
 */
public class SortedArrayToBST {


    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0) return null;
        return help(nums, 0, nums.length - 1);
    }


    private TreeNode help(int[] nums, int low, int high) {

        if (low > high) return null;
        int mid = low + (high - low) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = help(nums, low, mid - 1);
        node.right = help(nums, mid + 1, high);
        return node;

    }


}
