package tree;

import temp4.A;
import util.TreeNode;

import java.util.*;

public class findDuplicateSubtrees {
    static Map<String,TreeNode> set = new HashMap<>();
    static Set<TreeNode> result = new HashSet<>();


    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return new ArrayList<>(result);
    }

    public static String traverse(TreeNode root) {
        if(root==null){
            return "";
        }


        String serial = root.val + "(" + traverse(root.left) + ")(" + traverse(root.right) + ")";
        if(set.containsKey(serial)) result.add(set.get(serial));
        else set.put(serial,root);
        return serial;

    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        findDuplicateSubtrees(root);
        System.out.println();
    }
}
