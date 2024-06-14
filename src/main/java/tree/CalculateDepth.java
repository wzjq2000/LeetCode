package tree;

import com.alibaba.fastjson2.JSON;
import util.TreeNode;

public class CalculateDepth {
    int depth =0;
    int res = 0;
    public int calculateDepth(TreeNode root) {
        if(root!=null){
            depth++;
            res = Math.max(res, depth);
            calculateDepth(root.left);
            calculateDepth(root.right);
            depth--;


        }
        return res;
    }
}
