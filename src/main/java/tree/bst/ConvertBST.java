package tree.bst;

import util.TreeNode;

public class ConvertBST {
    public TreeNode convertBST(TreeNode root) {
        TreeNode home = root;
        int preSum = 0;
        sum(root,preSum);
        return home;
    }

    public int sum(TreeNode root, int preSum) {
        if(root==null) return preSum;
        preSum = sum(root.right,preSum)+root.val;
        root.val = preSum;
        preSum = sum(root.left,preSum);

        return preSum;
    }
}
