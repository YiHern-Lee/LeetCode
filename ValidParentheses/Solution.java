import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stk.push(s.charAt(i));
            } else {
                if (stk.empty()) return false;
                else if (s.charAt(i) == ')' && stk.peek() != '(') return false;
                else if (s.charAt(i) == ']' && stk.peek() != '[') return false;
                else if (s.charAt(i) == '}' && stk.peek() != '{') return false;
                stk.pop();
            }
        }
        return stk.empty();
    }
}