package dynamicPlan;

import java.util.ArrayList;
import java.util.List;

public class NthUglyNumber {
    public static void main(String[] args) {
        int n = 11;

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);

        int[] dp = new int[3];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            int current = Math.min(Math.min(list.get(dp[0])*2, list.get(dp[1])*3),list.get(dp[2])*5);
            if(current==list.get(dp[0])*2) dp[0]++;
            if(current==list.get(dp[1])*3) dp[1]++;
            if(current==list.get(dp[2])*5) dp[2]++;
            list.add(current);
        }

        System.out.println(list.get(n));


    }
}
