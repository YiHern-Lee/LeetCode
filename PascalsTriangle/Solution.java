import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generate(5));    
        System.out.println(s.generate(30));    
    }

    public List<List<Integer>> generate(int numRows) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(prev); 
        if (numRows == 1) return ans;
        for (int i = 1; i < numRows; i++) {
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for (int j = 0; j < prev.size() - 1; j++) {
                next.add(prev.get(j) + prev.get(j + 1));
            }
            next.add(1);
            prev = next;
            ans.add(next);
        }
        return ans;
    }
}