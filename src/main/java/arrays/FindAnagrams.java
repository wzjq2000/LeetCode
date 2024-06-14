package arrays;

import temp4.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
    public static List<Integer> findAnagrams(String total, String sub) {
        HashMap<Character, Integer> need = new HashMap<>(),window=new HashMap<>();
        for(char c: sub.toCharArray()){
            need.putIfAbsent(c,0);
            need.put(c,need.get(c)+1);
        }

        int right = 0, left = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        int totalLength = total.length();
        while (right<totalLength){
            char c = total.charAt(right);
            right++;

            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while(right-left==sub.length()){
                if(valid==need.size()){
                    res.add(left);
                }
                char d = total.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);

                }
            }

        }
        return res;

    }

    public static void main(String[] args) {
        String total = "cbaebabacd";
        String sub = "abc";
        System.out.println(findAnagrams(total, sub));
    }
}
