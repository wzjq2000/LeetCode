package greedy;

public class CanCompleteCircuit {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        int n = gas.length;
        int lastRemain = 0;
        int start = 0;
        int count = 0;
        for (start = 0; start < n; ) {
            if (gas[i % n] + lastRemain >= cost[i % n]) {
                lastRemain += gas[i % n] - cost[i % n];
                count++;
                if (count==n)
                    return start;

            } else {
                lastRemain = 0;
                start = i + 1;
                count = 0;
            }
            i++;
        }
        return -1;

    }


    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
//        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 5, 1, 2};
//        int[] cost = {3, 4, 3};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
