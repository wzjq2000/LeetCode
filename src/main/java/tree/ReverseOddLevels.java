package tree;

import temp4.A;
import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ReverseOddLevels {
    public static TreeNode reverseOddLevels(TreeNode root) {
        if(root==null) return null;
        Queue<TreeNode> even = new ArrayDeque<>();
        Queue<TreeNode> odd = new ArrayDeque<>();
        odd.offer(root);
        int count = 1;
        while(odd.size()>0||even.size()>0){
            if(count%2==1){
                intoQueue(odd,even);
            } else {
                reverseVal(even);
                intoQueue(even,odd);
            }
            count++;
        }

        return root;
    }

    public static void intoQueue(Queue<TreeNode> src, Queue<TreeNode> dst){
        int size = src.size();
        for (int i = 0; i < size; i++) {
            TreeNode poll = src.poll();
            if(poll.left!=null){
                dst.offer(poll.left);
            }
            if(poll.right!=null){
                dst.offer(poll.right);
            }

        }
    }

    public static void reverseVal(Queue<TreeNode> queue){
        List<TreeNode> list = new ArrayList<>();
        int size = queue.size();
        int left = 0,right = size-1;

        for (int i = 0; i < size; i++) {
            list.add(queue.poll());
        }
        while(left<right){
            TreeNode leftNode = list.get(left);
            TreeNode rightNode = list.get(right);
            int temp  = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = temp;
            left++;
            right--;
        }
        for (int i = 0; i < list.size(); i++) {
            queue.offer(list.get(i));

        }
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(3);
        t.right = new TreeNode(5);
        TreeNode treeNode = reverseOddLevels(t);
        System.out.println();
    }
}
