class Solution {
    public int reverse(int x) {
        if (x > -10 && x < 10) return x;
        int ans = 0; 
        boolean isP = x > 0;
        x = x < 0 ? x *= -1 : x;
        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < ans || (Integer.MAX_VALUE - x % 10) < ans * 10) return 0;
            ans = ans * 10 + x % 10;
            x /= 10;
        }        
        if (!isP) return -ans;
        else return ans;
    }
}