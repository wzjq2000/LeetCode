package dynamicPlan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSubstringInWraproundString {
    public static void main(String[] args) {
        String s = "zababc";
//        String s="acdzabcd";
//        Set<String> results = new HashSet<>();
//        for (int i = 0; i <= s.length()-1; i++) {
//            StringBuilder sb = new StringBuilder();
//            while(i<s.length()-1&&(s.charAt(i)+1==s.charAt(i+1)||(s.charAt(i)=='z'&&s.charAt(i+1)=='a'))){
//                sb.append(s.charAt(i));
//                i++;
//            }
//            sb.append(s.charAt(i));
//            findAllSubStrings(sb.toString(), results);
//        }
//
//        System.out.println(results.size());
        System.out.println(trueAnswer(s));
    }

    public static void findAllSubStrings(String str, Set<String> alreadyRecorded) {
        if (alreadyRecorded.contains(str)) return;
        alreadyRecorded.add(str);
        if (str.length() == 1) return;
        for (int i = str.length() - 1; i >= 1; i--) {
            for (int j = 0; j <= str.length() - i; j++) {
                findAllSubStrings(str.substring(j, j + i), alreadyRecorded);
//                if (alreadyRecorded.contains(str.substring(j,j+i))) continue;
//                alreadyRecorded.add(str.substring(j,j+i));
            }
        }
    }

    public static int trueAnswer(String s) {
        int dp[] = new int[26];
        dp[s.charAt(0) - 'a'] = 1;
        int temp = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) + 1 == s.charAt(i) || (s.charAt(i - 1) == 'z' && s.charAt(i) == 'a')) {
                // temp = dp[s.charAt(i - 1) - 'a'] + 1;
                temp++;
            } else {
                temp = 1;
            }
            dp[s.charAt(i) - 'a'] = Math.max(temp, dp[s.charAt(i) - 'a']);

        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {

            sum += dp[i];
        }
        return sum;
    }
}
