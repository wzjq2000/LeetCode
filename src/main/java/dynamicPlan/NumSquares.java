package dynamicPlan;

public class NumSquares {

    public static void main(String[] args) {

        int n = 12;
//        if (n==1) return 1;
//        if (n==2) return 2;
//        if (n==3) return 3;

        int[] dp = new int[n+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 2; j < i; j++) {
                if (i == j * j) {
                    dp[i] = 1;
                    break;
                } else {
                   dp[i] = Math.min(dp[i], dp[j]+dp[i-j]);
                }
            }
        }
        System.out.println(dp[n]);
//        return dp[n];
    }
}
