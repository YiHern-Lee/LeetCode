import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));
        System.out.println(sol.lengthOfLongestSubstring("abcdefgczyv"));
        System.out.println(sol.lengthOfLongestSubstring(""));
        System.out.println(sol.lengthOfLongestSubstring("a"));
        System.out.println(sol.lengthOfLongestSubstring("aaaaaaabcd"));
        System.out.println(sol.lengthOfLongestSubstring(" $###$$*()"));
    }
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int length = 0;
        int maxLength = 0;
        while (end < s.length()) {
            if (map.get(s.charAt(end)) == null) {
                map.put(s.charAt(end), length + 1);
                end++;
                length++;
            } else {
                start += map.get(s.charAt(end));
                end = start;
                map = new HashMap<>();
                if (length > maxLength) maxLength = length;
                length = 0;
            }
        }
        return maxLength > length ? maxLength : length;
    }
}