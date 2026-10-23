class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] == i) {
                continue;
            }
            result = result & nums[i];
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        }

        return result;
    }
}