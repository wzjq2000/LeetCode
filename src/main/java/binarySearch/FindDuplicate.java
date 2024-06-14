package binarySearch;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
//        int[] nums = {3,3,3,3};
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(int[] nums) {

        int left = 1;
        int right = nums.length-1;
        int mid=1;
        while(left<=right){
            mid = (left+right)/2;
            if(left==right) return mid;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]<=mid) sum++;
            }
            if (sum>mid){
                right = mid;
            } else {
                left= mid+1;
            }
        }
        return mid;
    }
}
