class Solution {
    public int fib(int n) {
        int fib0 = 0;
        int fib1 = 1;
        if (n == 0) return 0;
        if (n == 1) return 1;
        for (int i = 1; i < n; i++) {
            int next = fib0 + fib1;
            fib0 = fib1;
            fib1 = next;
        }
        return fib0;
    }
}