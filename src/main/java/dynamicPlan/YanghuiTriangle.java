package dynamicPlan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YanghuiTriangle {
    public static void main(String[] args) {
        int numRows=5;
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        result.add(Arrays.asList(1,1));
        for (int i = 3; i <= numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i-1; j++) {
                List<Integer> preRow = result.get(result.size() - 1);
                row.add(preRow.get(j-1)+preRow.get(j));
            }
            row.add(1);
            result.add(row);
        }

        System.out.println(result);

    }
}
