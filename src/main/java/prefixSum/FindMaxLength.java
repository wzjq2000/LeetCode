package prefixSum;

public class LongestArray {
    public static int longest(int[] nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        int n1 = sum;
        int n0 = nums.length-sum;
        int left = 0;
        int right = nums.length-1;
        while(n0!=n1&&n0>0&&n1>0){
            if(n0>n1){
                if(nums[left]==0) {
                    left++;
                    n0--;
                }
                else if (nums[right]==0){
                    right--;
                    n0--;
                } else {
                    left++;
                    n1--;
                }
            } else {
                if(nums[left]==1) {
                    left++;
                    n1--;
                }
                else if (nums[right]==1){
                    right--;
                    n1--;
                } else {
                    left++;
                    n0--;
                }
            }

        }
        return n0*2;
    }
}
