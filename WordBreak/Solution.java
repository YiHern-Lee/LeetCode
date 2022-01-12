import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(s.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", 
                Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> dict = new HashMap<>();
        for (String word : wordDict) dict.putIfAbsent(word, true);
        return aux(s, 0, s.length(), dict);

    }

    public boolean aux(String s, int start, int end, HashMap<String, Boolean> dict) {
        if (start == end) return true;
        for (int i = start + 1; i <= end; i++) {
            System.out.println(i);
            if (dict.containsKey(s.substring(start, i))) {
                if(aux(s, i, end, dict)) return true;
            }
        }
        return false;
    }
}