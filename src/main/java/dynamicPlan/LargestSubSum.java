package dynamicPlan;

import java.util.Arrays;

public class LargestSubSum {

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];  // 以nums[i]为结尾的所有子数组中,能得到最大sum的子数组的sum.
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(dp[i-1]<=0){
                dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            } else {
                dp[i] = dp[i-1]+nums[i];
            }
        }
        return findMax(dp)[1];
    }


//    public static int maxSubArrayNotGood(int[] nums) {
//        int len = nums.length;
//        if(len==0) return Integer.MIN_VALUE;
//        if (len == 1) return nums[0];
//        int fromLeft[] = new int[len];
//        int fromRight[] = new int[len];
//        int sum = 0;
//        for (int i = 0; i < len; i++) {
//            sum += nums[i];
//            fromLeft[i] = sum;
//        }
//        sum = 0;
//        for (int i = 0; i < len; i++) {
//            sum += nums[len - 1 - i];
//            fromRight[len - 1 - i] = sum;
//        }
//        int left[] = findMin(fromLeft,false);
//        int right[] = findMin(fromRight,true);
//
//        if (left[0] < right[0]) {
//            if (left[1] > 0) left[1] = 0;
//            if (right[1] > 0) right[1] = 0;
//
//            return sum - left[1] - right[1];
//        }  else if (left[0] == right[0]) {
//            int numsLeft[] = new int[left[0]];
//            int numsRight[] = new int[len - 1 - right[0]];
//
//            for (int i = 0; i < left[0]; i++) {
//                numsLeft[i] = nums[i];
//            }
//            for (int i = right[0]+1; i < len; i++) {
//                numsRight[i-right[0]-1] = nums[i];
//            }
//            return Math.max(Math.max(sum,maxSubArrayNotGood(numsLeft)), maxSubArrayNotGood(numsRight));
//        }
//        else{
//            int numsLeft[] = new int[right[0]];
//            int numsRight[] = new int[len - 1 - left[0]];
//
//            if(numsLeft.length==0 && numsRight.length==0){
//                return findMax(nums)[1];
//            }
//            for (int i = 0; i < right[0]; i++) {
//                numsLeft[i] = nums[i];
//            }
//            for (int i = left[0]+1; i < len; i++) {
//                numsRight[i-left[0]-1] = nums[i];
//            }
//            return Math.max(Math.max(sum,maxSubArrayNotGood(numsLeft)), maxSubArrayNotGood(numsRight));
//        }
//    }

    public static int[] findMin(int[] arr, boolean reverse) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        if (reverse) {
            for (int i = 0; i < arr.length; i++) {
                if (min >= arr[i]) {
                    min = arr[i];
                    minIndex = i;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }
        return new int[]{minIndex, min};
    }


    public static int[] findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }

        }
        return new int[]{maxIndex, max};
    }

    public static void main(String[] args) {
//        int nums[]={5,4,-1,7,8};
//        int nums[]={-2,-1};
//        int nums[] = {-2, 1};
//        int nums[]={8,-19,5,-4,20};
//        int nums[]={1,2,-1,-2,2,1,-2,1};
//        int nums[]={3,-2,-3,-3,1,3,0};
//        int nums[] = {0, -3, -2, -3, -2, 2, -3, 0, 1, -1};
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
//        int nums[]={-84,-87,-78,-16,-94,-36,-87,-93,-50,-22,-63,-28,-91,-60,-64,-27,-41,-27,-73,-37,-12,-69,-68,-30,-83,-31,-63,-24,-68,-36,-30,-3,-23,-59,-70,-68,-94,-57,-12,-43,-30,-74,-22,-20,-85,-38,-99,-25,-16,-71,-14,-27,-92,-81,-57,-74,-63,-71,-97,-82,-6,-26,-85,-28,-37,-6,-47,-30,-14,-58,-25,-96,-83,-46,-15,-68,-35,-65,-44,-51,-88,-9,-77,-79,-89,-85,-4,-52,-55,-100,-33,-61,-77,-69,-40,-13,-27,-87,-95,-40};
        System.out.println(maxSubArray(nums));

    }
}
