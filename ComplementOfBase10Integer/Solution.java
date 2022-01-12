class Solution {
    public int bitwiseComplement(int n) {
        int m = 1;
        while (Math.pow(2, m) - 1 < n) m++;
        return (int) Math.pow(2, m) - 1 - n;
    }
}