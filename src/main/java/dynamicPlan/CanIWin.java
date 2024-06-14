package dynamicPlan;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {
//    public static void main(String[] args) {
//        int maxChoosableInteger= 4;
//        int desiredTotal = 8;
//
//
//
//    }
//
//    public static boolean canIWin(int maxChoosableInteger, int desiredTotal){
//        if (maxChoosableInteger>=desiredTotal) return true;
//
//        int n = maxChoosableInteger;
//        int total = 1;
//        for (int i = 2; i < n; i++) {
//            total*=i;
//
//        }
//        int dp[][] = new int[n][total];
//
//
//
//    }

    public static void main(String[] args) {
        System.out.println(canIWin(4,8));
    }

    static Map<Integer, Boolean> memo = new HashMap<Integer, Boolean>();
    public static  boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * (maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }
        return dfs(maxChoosableInteger, 0, desiredTotal, 0);
    }

    public static boolean dfs(int maxChoosableInteger, int usedNumbers, int desiredTotal, int currentTotal) {
        if (!memo.containsKey(usedNumbers)) {
            boolean res = false;
            for (int i = 0; i < maxChoosableInteger; i++) {
                if (((usedNumbers >> i) & 1) == 0) {
                    if (i + 1 + currentTotal >= desiredTotal) {
                        res = true;
                        break;
                    }
                    if (!dfs(maxChoosableInteger, usedNumbers | (1 << i), desiredTotal, currentTotal + i + 1)) {
                        res = true;
                        break;
                    }
                }
            }
            memo.put(usedNumbers, res);
        }
        return memo.get(usedNumbers);
    }
}
