import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int start, end, sum;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            start = i + 1;
            end = nums.length - 1;
            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start < end && nums[start + 1] == nums[start]) start++;
                    while (end > end && nums[end - 1] == nums[end]) end--;
                    start++;
                    end--;
                } 
                else if (sum < 0) start++;
                else end--;
            }
        }
        return ans;
    }
}

// [-4,-1,-1,0,1,2]