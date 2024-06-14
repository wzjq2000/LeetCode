package arrays;

import temp4.A;

import java.util.*;
import java.util.stream.IntStream;

public class AdvantageCount {
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Integer[] index2 = new Integer[nums2.length] ;


        for (int i = 0; i < nums1.length; i++) {
            index2[i] = i;
        }

        Arrays.sort(index2,(o1,o2)->nums2[o1]-nums2[o2]);

        int[] ans = new int[nums1.length];

        int left = 0, right = nums1.length-1;
        for(int x:nums1){
            if (x>nums2[index2[left]]){
                ans[index2[left]] = x;
                left++;
            } else {
                ans[index2[right]] = x;
                right--;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums1 = {12,24,8,32};
        int[] nums2 = {13,25,32,11};
        int[] ints = advantageCount(nums1, nums2);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+", ");

        }
    }
}
