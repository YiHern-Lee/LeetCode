import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] < minDiff ) {
                ans = new LinkedList<>();
                List<Integer> pair = new ArrayList<>();
                minDiff = arr[i + 1] - arr[i];
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.add(pair);
            } else if (arr[i + 1] - arr[i] == minDiff) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.add(pair);
            }
        }
        return ans;
    }
}