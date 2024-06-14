package dynamicPlan;

public class IsInterleave {
    public static void main(String[] args) {
//        String s1 = "aabcc";
//        String s2 = "dbbca";
//        String s3 = "aadbbcbcac";
        String s1 = "db";
        String s2 = "b";
        String s3 = "cbb";

        boolean dp[][] = new boolean[s2.length()+1][s1.length()+1];
        dp[0][0] = true;

        for (int i = 0; i < s1.length(); i++) {
            if (s3.charAt(i) == s1.charAt(i))
                dp[0][i+1] = true;
            else break;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s3.charAt(i) == s2.charAt(i))
                dp[i+1][0] = true;
            else break;
        }

        for (int i = 1; i <= s2.length(); i++) {
            for (int j = 1; j <= s1.length(); j++) {
                if (dp[i - 1][j] == false && dp[i][j - 1] == false) continue;
                else if (dp[i - 1][j] == false) {
                    dp[i][j] = (s3.charAt(i + j - 1) == s1.charAt(j - 1));
                } else if (dp[i][j - 1] == false) {
                    dp[i][j] = (s3.charAt(i + j - 1) == s2.charAt(i - 1));
                } else {
                    dp[i][j] = (s3.charAt(i + j - 1) == s2.charAt(i - 1)) || (s3.charAt(i + j - 1) == s1.charAt(j - 1));
                }
            }
        }

        System.out.println(dp[s2.length()][s1.length()]);
    }
}
