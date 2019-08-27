package learn_training.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsValidBST {


    boolean flag=true;
    public boolean isValidBST(TreeNode root) {

        Stack<Integer> stack=new Stack<>();
        help(root,stack);
        return flag;
    }


    private void help(TreeNode node, Stack<Integer> list) {

        if (node == null) return;
        help(node.left, list);
        if (!list.isEmpty()){
            int peek=list.peek();
            if (peek>node.val){
                flag=false;
                return;
            }
        }
        help(node.right, list);
    }

}
