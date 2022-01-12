import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.partition("baaab"));    
    }

    public List<List<String>> partition(String s) {
        return aux(s, 0, s.length());
    }

    static List<List<String>> aux(String s, int start, int end) {
        List<List<String>> ans = new LinkedList<>();
        if (start >= end) {
            ans.add(new LinkedList<>());
            return ans;
        }
        for (int i = 1; start + i <= end; i++) {
            if (isPalindrome(s, start, start + i)) {
                /* System.out.println(s.substring(start, start + i)); */
                List<List<String>> res = aux(s, start + i, end);
                for (List<String> lst : res) lst.add(0, s.substring(start, start + i));
                ans.addAll(res);
            }
        }
        return ans;
    }

    static boolean isPalindrome(String s, int start, int end) {
        boolean bool = true;
        int i = start, j = end - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                bool = false;
                break;
            }
            i++;
            j--;
        }
        return bool;
    }
}