package prefixSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMaxLength {
    public static int findMaxLength(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        ArrayList<Integer> temp = new ArrayList<>();
        map.put(0, temp);
        temp.add(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
            if (i > 0)
                nums[i] = nums[i - 1] + nums[i];

            List<Integer> indices = map.computeIfAbsent(nums[i], (k) -> new ArrayList<Integer>());
            indices.add(i + 1);
        }
        int max = 0;
        for (List<Integer> e : map.values()) {
            int i = e.get(e.size() - 1) - e.get(0);
            if (max < i) max = i;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1,0,1};
        System.out.println(findMaxLength(nums));
    }
}
