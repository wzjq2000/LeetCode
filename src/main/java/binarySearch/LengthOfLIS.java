package binarySearch;

import java.util.Arrays;
import java.util.OptionalInt;

public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // 1. 动态规划
//        int max = 1;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (i == nums.length - 1) dp[i] = 1;
//            else {
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[j] > nums[i]) dp[i] = Math.max(dp[j] + 1, dp[i]);
//                    else if (dp[i] == 0)
//                        dp[i] = 1;
//                }
//            }
//            max = Math.max(dp[i], max);
//        }
//        return max;

        // 2. 贪心+二分
        int p[] = new int[nums.length];  // p[i]: 所有长度为i+1的递增数组中的末尾最小值
        int c = 0;
        p[0]=nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > p[c]) {
                c++;
                p[c] = nums[i];
            } else if (nums[i] < p[c]) {
                binarySearch(p, c, nums[i]);
            }
        }
        return c+1;
    }

    public static void binarySearch(int[] p, int right, int target) {
        int left = 0;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (p[mid] > target) {
                right = mid - 1;
            } else if (p[mid] < target) {
                left = mid + 1;
            } else {
                return;
            }
        }
        if (p[mid] < target) {
            p[left] = target;
        } else {
            p[mid] = target;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {0,2,0,3,1};
//        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(nums));

    }
}
