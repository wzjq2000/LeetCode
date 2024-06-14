package dynamicPlan;

import java.util.*;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {

//        boolean dp[] = new boolean[Integer.MAX_VALUE];
        List<Boolean> results = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        helper(s,wordDict,results,dict);

        if(results.size()!=0) return true;
        return false;


    }

    public static void helper(String s, List<String> wordDict, List<Boolean> results, Set<String> dict){
        if(s.length()==0) {
            results.add(true);
            return;
        }
        int i=0;
        for (i = 0; i < wordDict.size(); i++) {
            if (s.startsWith(wordDict.get(i))){
                String replace = s.replaceFirst(wordDict.get(i), "");
                if (dict.contains(replace)) continue;
                dict.add(replace);
                helper(replace, wordDict, results, dict);
            }
        }
    }

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("cats","cat","dog","ski");
        String s = "catskicatcats";
        System.out.println(wordBreak(s,wordDict));


    }
}
