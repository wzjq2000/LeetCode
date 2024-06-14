package tree;

import util.TreeNode;

import javax.sound.midi.Soundbank;
import java.util.Collections;
import java.util.PriorityQueue;

public class ConstructMaximumBinaryTree {
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, -1, nums.length);
    }

    public static TreeNode build(int[] nums, int start, int end) {
        // start与end都不含
        if (start == end-1 ) return null;

        Integer poll = findLargestIndex(nums,start, end);
        TreeNode treeNode = new TreeNode(nums[poll]);
        treeNode.left = build(nums, start, poll);
        treeNode.right = build(nums, poll, end);
        return treeNode;
    }

    public static int findLargestIndex(int[] nums, int start, int end){
        int max = nums[start+1];
        int maxIndex = start+1;
        for (int i = start+1; i < end; i++) {
            if(max<nums[i]){
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    public static void main(String[] args) {
        int[] nums={3,2,1,6,0,5};
        TreeNode treeNode = constructMaximumBinaryTree(nums);
        System.out.println();
    }
}
