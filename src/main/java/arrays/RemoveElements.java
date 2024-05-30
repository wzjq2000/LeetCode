package arrays;

public class RemoveElements {
    public int removeElements(int[] nums, int val) {
        int slow=0;
        int quick = 0;
        while(quick<nums.length) {
            if (nums[quick] == val) {
                if (nums[slow] == val) {
                } else {
                    slow = quick;
                }
            } else {
                nums[slow] = nums[quick];
            }
            quick++;

        }
        return slow+1;
    }
}
