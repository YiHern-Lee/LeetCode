class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int left = 0;
        int right = 0;
        int maxf = 0;
        int maxLength = 0;
        while (right < s.length()) {
            // Check if after adding this character
            // the replacements are more than k
            map[s.charAt(right) - 'A'] = Math.max(map[s.charAt(right) - 'A'] + 1, 0);
            maxf = Math.max(maxf, map[s.charAt(right) - 'A']);
            while (right - left + 1 - maxf > k) {
                map[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(right - left + 1, maxLength);
            right++;
        }
        return maxLength;
    }
}