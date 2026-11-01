class Solution {
    public int minMoves(int[] nums) {

        int n=nums.length;
        int sum=0;
        int min=nums[0];

        for (int num:nums){
            min = Math.min(min, num);

        }

        for (int num : nums) {
            sum += num - min;
        }

        return sum;

        
    }
}