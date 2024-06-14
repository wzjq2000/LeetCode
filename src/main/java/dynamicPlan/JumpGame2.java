package dynamicPlan;


// 45
public class JumpGame2 {
    public static int jump(int[] nums) {
//        // 方法一:
//        int[] dp = new int[nums.length];
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 1; j <= nums[i] && j+i<dp.length; j++) {
//                if (dp[j+i]==0) dp[j+i]=dp[i]+1;
//            }
//        }
//        return dp[nums.length-1];

        // 方法二:
        if(nums.length<=1) return 0;

        int cursor = 0;
        int maxBound = nums[0];
        int step = 0;

        while (maxBound < nums.length-1) {
            int temp = 0;
            for (int i = 1; i <= nums[cursor]; i++) {
                if (nums[cursor + i] + cursor + i > maxBound) {
                    maxBound = nums[cursor + i] + cursor + i;
                    temp = cursor + i;
                }
            }
            cursor = temp;
            step++;
        }
        return step+1;
    }


//    // 从数组中index为src的数字是否可以到达index为dest的数字
//    public boolean isReachable(int[] nums, int src, int dest){
//        if (nums[src]+src>=dest) return true;
//        return false;
//    }


    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(jump(nums));

    }
}
