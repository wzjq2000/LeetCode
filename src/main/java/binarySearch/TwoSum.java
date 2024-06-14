package binarySearch;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        int left =0;
        int right=0;
        int cursor = 0;
        for(int i=0; i<nums.length;i++){
            cursor = i;
            left = i+1;
            right = nums.length-1;
            int realTarget = target-nums[cursor];
            while (left<=right){
                int mid = (left+right)/2;
                if (nums[mid]>realTarget){
                    right = mid-1;
                } else if (nums[mid]<realTarget){
                    left = mid+1;
                }else {
                    return new int[]{cursor+1, 1+mid};
                }

            }
        }

        return new int[]{cursor+1,left+1};

    }

    public static void main(String[] args) {
        int nums[]={2,3,4};
        int target = 6;
        System.out.println(twoSum(nums,target));
    }
}
