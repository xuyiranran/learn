package learn_training.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 257:binary tree paths
 *
 *
 *
 */
public class BinaryTreePaths {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        help(root, result, "");
        return result;
    }

    /**
     * @param node
     * @param strings
     * @param string
     */
    private void help(TreeNode node, List<String> strings, String string) {

        if (node == null) return;
        string += Integer.valueOf(node.val);
        if (node.left == null && node.right == null) {
            strings.add(string);
        } else {
            string += "->";
            help(node.left, strings, string);
            help(node.right, strings, string);
        }
    }


}
