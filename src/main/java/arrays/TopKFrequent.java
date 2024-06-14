package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//347
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(num->{
            map.put(num, map.computeIfAbsent(num, key->0)+1);
        });
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().collect(Collectors.toList());
        collect.sort((o1,o2)->o1.getValue()-o2.getValue());
        int[] result=new int[k];
//        int cursor=0;
//        int temp = collect.get(cursor).getValue();
        for (int i = 0; i < k; i++) {
            result[i] = collect.get(i).getKey();
        }
        return result;

    }
}
