package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//49
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> result = new ArrayList<>();
        HashMap<List<Integer>, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            int key1=1;
            int key2=0;
            for (int j=0 ; j<chars.length; j++){
                key1 *= (chars[j]-'a');
                key2 +=(chars[j]-'a');
            }
            List<Integer> key = new ArrayList<>();
            key.add(key1);
            key.add(key2);
            key.add(strs[i].length());

            if (!map.containsKey(key))
            {
                ArrayList<String> subResult = new ArrayList<>();
                subResult.add(strs[i]);
                map.put(key, subResult);
                result.add(subResult);
            } else {
                List<String> subResult = map.get(key);
                subResult.add(strs[i]);
            }
        }
        return result;

    }
}



