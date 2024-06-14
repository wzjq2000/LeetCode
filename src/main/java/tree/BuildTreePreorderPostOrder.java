package tree;

import util.TreeNode;

public class BuildTreePreorderPostOrder {
    public static TreeNode buildTree(int[] preorder, int[] postorder) {
        return helper(preorder, 0, preorder.length-1, postorder,0,postorder.length-1);
    }

    public static TreeNode helper(int[] preorder, int startPre, int endPre, int[] postorder, int startPo, int endPo) {

        if(startPre>endPre||startPo>endPo)
            return null;

        TreeNode root = new TreeNode(postorder[endPo]);

        if(startPre==endPre||startPo==endPo) return root;

        int index = findIndex(postorder,preorder[startPre+1]);
        if (index!=endPo-1){
            root.left = helper(preorder, startPre+1, index-startPo+1+startPre,postorder,startPo,index);
            root.right = helper(preorder, index-startPo+2+startPre, endPre, postorder, index+1, endPo-1);
        } else {
            root.right = helper(preorder, startPre+1, index-startPo+1+startPre, postorder, startPo, index);

        }
        return root;

    }

    public static int findIndex(int nums[], int target){
        for (int i = 0; i < nums.length; i++) {
            if(target==nums[i]) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
//        int[] preorder = {1,2,4,5,3,6,7};
//        int[] postorder = {4,5,2,6,7,3,1};
        int[] preorder = {4,2,1,3};
        int[] postorder = {3,1,2,4};
        TreeNode treeNode = buildTree(preorder, postorder);
        System.out.println();

    }
}
