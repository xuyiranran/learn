package learn_training.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumV2 {



    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();

        help(root,sum,result,tmp);
        return null;

    }


    private void help(TreeNode node,int sum,List<List<Integer>> result,List<Integer> tmp){

        if (node==null)return;
        tmp.add(node.val);
        sum=sum-node.val;
        if (node.left==null&&node.right==null&&sum==0){
            result.add(tmp);
        }
        help(node.left,sum,result,tmp);
        help(node.right,sum,result,tmp);
        tmp.remove(tmp.size()-1);


    }



}
