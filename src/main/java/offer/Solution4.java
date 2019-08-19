package offer;

/**
 * 重建二叉树
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果,请重建出该二叉树
 *
 *
 * 需要画图分析否则这题很难思考出来
 *
 */
public class Solution4 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre.length==0||in.length==0||(pre.length!=in.length)){
            return null;
        }
        return buildTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    private TreeNode buildTree(int[] pre,int preStart,int preEnd,int[] in ,int inStart,int inEnd){
        if (preStart>preEnd){
            return null;
        }
        int value=pre[preStart];
        int index=inStart;
        while (index<=inEnd&&value!=in[index]){
            index++;
        }
        TreeNode node=new TreeNode(value);
        node.left=buildTree(pre,preStart+1,preStart+index-inStart,in,inStart,index-1);
        node.right=buildTree(pre,preStart+index-inStart+1,preEnd,in,index+1,inEnd);
        return node;
    }

}
