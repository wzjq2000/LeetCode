package dynamicPlan;

import java.util.*;

public class DiffWaysToCompute {
    public static void main(String[] args) {
        String exp = "2*3-4*5";
        Set<Character> opSet = new HashSet<>();
        opSet.add('*');
        opSet.add('+');
        opSet.add('-');
        List<Integer> result = null;
        Map<String, List<Integer>> dict = new HashMap<>();
        result = recurse(exp, dict, opSet);
        System.out.println(result);


    }

    public static int cal(int left, char op, int right) {
        if (op == '+') return left + right;
        if (op == '-') return left - right;
        if (op == '*') return left * right;
        return 0;
    }

    public static List<Integer> recurse(String exp, Map<String, List<Integer>> dict, Set<Character> opSet) {
        if (dict.containsKey(exp)) return dict.get(exp);
        List<Integer> result = new ArrayList<>();
        dict.put(exp, result);

        boolean flag = false;
        for (int i = 0; i < exp.length(); i++) {
            if (opSet.contains(exp.charAt(i))) {
                flag = true;
                String left = exp.substring(0, i);
                String right = exp.substring(i + 1);
                List<Integer> l = recurse(left, dict, opSet);
                List<Integer> r = recurse(right, dict, opSet);
                for (int j = 0; j < l.size(); j++) {
                    for (int k = 0; k < r.size(); k++) {
                        int cal = cal(l.get(j), exp.charAt(i), r.get(k));
                        result.add(cal);
                    }
                }
            }
        }
        if (!flag) {
            result.add(Integer.parseInt(exp));
        }
        return result;

    }


    public static void parse(String exp, List<Integer> nums, List<Character> ops) {
        Set<Character> opSet = new HashSet<>();
        opSet.add('*');
        opSet.add('+');
        opSet.add('-');

        for (int i = 0; i < exp.length(); i++) {
            int j = i;
            while (!opSet.contains(exp.charAt(j))) {
                j++;
            }
            nums.add(Integer.parseInt(exp.substring(i, j)));
            ops.add(exp.charAt(j));
            i = j;
        }
    }
}