import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                ArrayList<Integer> val = new ArrayList<>();
                val.add(i);
                map.put(nums[i], val);
            } else {
                ArrayList<Integer> val = map.get(nums[i]);
                val.add(i);
                map.put(nums[i], val);
            }
        }
        for (int num : nums) {
            if (map.containsKey(target - num) && target - num == num) {
                ArrayList<Integer> val = map.get(target - num);
                if (val.size() < 2) continue;
                return new int[] { val.get(0), val.get(1) };
            } else if (map.containsKey(target - num)) {
                ArrayList<Integer> val1 = map.get(num);
                ArrayList<Integer> val2 = map.get(target - num);
                return new int[] { val1.get(0), val2.get(0) };
            }
            
        }
        return new int[] {};
    }
}