package tree;

import dynamicPlan.Rob2;
import util.TreeNode;

public class BuildTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        return helper(preorder,0,preorder.length-1, inorder, 0, inorder.length-1);
    }

    public static TreeNode helper(int[] preorder, int startP, int endP, int[] inorder, int startIn, int endIn){
        if(startP>endP)
            return null;
        if(startIn>endIn)
            return null;

        TreeNode root = new TreeNode(preorder[startP]);

        int index = findIndex(inorder, root.val);
        root.left = helper(preorder,startP+1,startP+index-startIn, inorder, startIn, index-1);

        root.right=  helper(preorder, startP+index-startIn+1, endP, inorder, index+1, endIn);
        return root;
    }

    public static int findIndex(int nums[], int target){
        for (int i = 0; i < nums.length; i++) {
            if(target==nums[i]) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        int preorder[] = {3,9,20,15,7};
        int inorder[] = {9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println();
    }
}
