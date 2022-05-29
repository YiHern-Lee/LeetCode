import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int ptr = 0;
        int length = 0;
        int maxLength = 0;
        while (ptr < s.length()) {
            if (!map.containsKey(s.charAt(ptr))) {
                map.put(s.charAt(ptr), ptr);
                ptr++;
                length++;
            } else {
                ptr = map.get(s.charAt(ptr)) + 1;
                map = new HashMap<>();
                length = 0;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}