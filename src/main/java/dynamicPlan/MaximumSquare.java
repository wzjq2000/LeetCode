package dynamicPlan;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import sun.java2d.xr.MaskTile;

public class MaximumSquare {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        int[][] matrix = {{ 0, 1}, {1,0}};

        int sum = 1;
        int row = matrix.length;
        int col = matrix[0].length;
        if (row==1 || col==1) sum=0;

        int dp[][] = new int[row][col];

        int len = -1;

        for (int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0]==0? 0:1;
            sum+=(matrix[i][0]);
            len = Math.max(len, dp[i][0]);

        }


        for (int i = 0; i < col; i++) {
            dp[0][i] = matrix[0][i]==0? 0:1;
            sum+=(matrix[0][i]);
            len = Math.max(len, dp[0][i]);

        }


        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1])+1;
                len = Math.max(len, dp[i][j]);
            }
        }

        if(sum!=0 && len==-1) len=1;
        System.out.println(len*len);

    }

}

