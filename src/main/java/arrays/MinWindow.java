package arrays;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public static String minWindow(String s, String t) {
        String result = s;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        Map<Character, Integer> temp = new HashMap<>();
        temp.putAll(map);
        for (char c : s.toCharArray()) {
            if (temp.containsKey(c)) {
                temp.put(c, temp.get(c) - 1);
            }
        }
        for (int times : temp.values()) {
            if (times > 0) return "";
        }

        int n = 0;
        temp.putAll(map);

        for (left = 0; left < s.length(); left++) {
            if (map.containsKey(s.charAt(left))) {
                if(temp.get(s.charAt(left))<0){
                    temp.put(s.charAt(left), temp.get(s.charAt(left))+1);
                    continue;
                }
                temp = new HashMap<>();
                temp.putAll(map);
                n = t.length();
                for (right = left; right < s.length(); right++) {
                    if (n == 0) {
                        if (result.length() > right - left) {
                            result = s.substring(left, right);
                            break;
                        }
                    }
                    if (map.containsKey(s.charAt(right))) {
                        int times = temp.get(s.charAt(right));
                        if (times > 0) {
                            n--;
                        }
                        times--;
                        temp.put(s.charAt(right), times);
                    }
                }
                if (n == 0) {
                    if (result.length() > right - left) {
                        result = s.substring(left, right);
                    }
                }

            }

        }
        return result;
    }

    public static void main(String[] args) {
        String s = "aaabbbbbcdd";
        String t = "abcdd";
        System.out.println(minWindow(s, t));
    }
}
