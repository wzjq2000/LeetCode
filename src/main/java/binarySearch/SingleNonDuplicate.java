package binarySearch;

public class SingleNonDuplicate {
    public static void main(String[] args) {
//        int[] nums = {1,1,2,3,3,4,4,8,8};
        int[] nums = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(nums));
    }
    public static int singleNonDuplicate(int[] nums) {
        if (nums.length<=0) return 0;
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left<=right){
            mid = (left+right)/2;
            if (left==right) return mid;
            if(mid%2!=0){
                if(nums[mid]==nums[mid+1]) right = mid-1;
                else if(nums[mid]==nums[mid-1]) left = mid+1;
                else return mid;
            }
            else{
                if(nums[mid]==nums[mid+1]) left = mid+2;
                else if(nums[mid]==nums[mid-1]) right = mid-2;
                else return mid;

            }
        }
        return mid;
    }

}
