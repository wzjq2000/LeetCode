package dynamicPlan;

public class UniquePath2 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][0] != 1)
            dp[0][0] = 1;
        for (int i = 1; i < dp[0].length; i++) {
//            dp[0][i] = (obstacleGrid[0][i] == 0 ? 1 : 0);
//            if (dp[0][i - 1] == 0) dp[0][i]=0;

            boolean A = obstacleGrid[0][i] != 0;
            boolean B = dp[0][i - 1] != 0;
            dp[0][i] = ((A ^ B) & !A) ? 1 : 0;
        }
        for (int i = 1; i < dp.length; i++) {
//            dp[i][0] = (obstacleGrid[i][0] == 0? 1 : 0);
//            if(dp[i - 1][0] == 0) dp[i][0] = 0;
            boolean A = obstacleGrid[i][0] != 0;
            boolean B = dp[i - 1][0] != 0;
            dp[i][0] = ((A ^ B) & !A) ? 1 : 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];


    }

    public static void main(String[] args) {
        int[][] a = {{0, 1, 0}, {0, 0, 0}};
        int[][] b = new int[a.length][a[0].length];
        System.out.println(b.length);
        System.out.println(a.length);
//        System.out.println(b[0].length);
//        System.out.println(a[0].length);
        System.out.println(uniquePathsWithObstacles(a));
    }
}
