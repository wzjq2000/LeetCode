package tree;

import util.TreeNode;

import java.time.temporal.Temporal;

public class BuildTreeInorderPostorder {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
       return helper(inorder, 0, inorder.length-1, postorder,0,postorder.length-1);
    }

    public static TreeNode helper(int[] inorder, int startIn, int endIn, int[] postorder, int startPo, int endPo) {
        if(startPo>endPo) return null;
//        if(startIn>endIn) return null;

        TreeNode root = new TreeNode(postorder[endPo]);
        int index = findIndex(inorder, root.val);
        root.left = helper(inorder, startIn, index-1,postorder,startPo,startPo+index-startIn-1);
        root.right = helper(inorder, index+1, endIn, postorder, startPo+index-startIn, endPo-1);
        return root;

    }

    public static int findIndex(int nums[], int target){
        for (int i = 0; i < nums.length; i++) {
            if(target==nums[i]) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode treeNode = buildTree(inorder, postorder);
        System.out.println();
    }
}
