import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution run = new Solution();
        System.out.println(run.longestPalindrome("babad"));
        System.out.println(run.longestPalindrome("cbbd"));
        System.out.println(run.longestPalindrome("a"));
        System.out.println(run.longestPalindrome("ac"));
    }

    public String longestPalindrome(String s) {
        List<Palindrome> possiblePalindromes = new LinkedList<>();
        int idx = 0;
        while (inbounds(idx, s.length())) {
            StringBuilder palindrome = new StringBuilder();
            int start = idx;
            int end = idx;
            palindrome.append(s.charAt(idx));
            idx++;
            while (inbounds(idx, s.length()) && s.charAt(idx) == s.charAt(idx - 1)) {
                palindrome.append(s.charAt(idx));
                end++;
                idx++;
            }
            possiblePalindromes.add(new Palindrome(palindrome, start, end));
        }
        StringBuilder ans = possiblePalindromes.get(0).sb;
        int size = possiblePalindromes.get(0).size;
        for (Palindrome palindrome : possiblePalindromes) {
            StringBuilder longerPalindrome = new StringBuilder(palindrome.sb);
            int currSize = palindrome.size;
            int nextDown = palindrome.start - 1;
            int nextUp = palindrome.end + 1;
            while (inbounds(nextDown, s.length()) && inbounds(nextUp, s.length()) && s.charAt(nextDown) == s.charAt(nextUp)) {
                currSize += 2;
                longerPalindrome.insert(0, s.charAt(nextDown));
                longerPalindrome.append(s.charAt(nextUp));
                nextUp++;
                nextDown--;
            }
            if (currSize > size) {
                size = currSize;
                ans = longerPalindrome;
            }
        }

        return ans.toString();
    }

    static boolean inbounds(int i, int ceil) {
        return i >= 0 && i < ceil;
    }

    static class Palindrome {
        StringBuilder sb;
        int start;
        int end;
        int size;
        Palindrome (StringBuilder s, int start, int end) {
            this.sb = s;
            this.start = start;
            this.end = end;
            this.size = end - start + 1;
        }

        @Override
        public String toString() {
            return sb.toString();
        }
    }
}
