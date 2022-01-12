import java.util.BitSet;

class Solution {
    public int firstMissingPositive(int[] nums) {
        BitSet bits = new BitSet();
        for (int num : nums) {
            if (num > 0 && num <= nums.length) bits.set(num);
        }
        return bits.nextClearBit(1);
    }
}
