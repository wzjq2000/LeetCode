package dynamicPlan;

public class Rob2 {
    public static int rob(int[] nums) {
        if (nums.length==1) return nums[0];
        return Math.max(findLargest(nums,0,nums.length-2),findLargest(nums,1,nums.length-1));
    }

    public static int findLargest(int[] nums, int start, int end){
        // start与end为index,形成的是闭区间

        if (end==start){
            return nums[start];
        } else if (end-start==1) {
            return Math.max(nums[start],nums[end]);
        }

//        int dp[] = new int[end-start+1];
//        dp[0] = nums[start];
//        dp[1] = nums[start+1];
//        dp[2] = nums[start+2]+dp[0];

        int var0 = nums[start];
        int var1 = nums[start+1];
        int var2 = nums[start+2]+var0;
        int var3;


        for (int i = 3; i < end-start+1; i++) {
//            dp[i] = nums[i+start]+Math.max(dp[i-2],dp[i-3]);
            var3 = nums[i+start]+Math.max(var1,var0);
            var0 = var1;
            var1 = var2;
            var2 = var3;
        }

//        return Math.max(dp[dp.length-1], dp[dp.length-2]);
        return Math.max(var2, var1);
    }

    public static void main(String[] args) {
//        int nums[] = {2,3,2};
        int nums[] = {1,2,3,1};
        System.out.println(rob(nums));
    }


}
