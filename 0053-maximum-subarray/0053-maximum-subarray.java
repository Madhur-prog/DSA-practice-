class Solution {
    public int maxSubArray(int[] nums) {

        int n=nums.length;
        int currentsum=nums[0];
        int maxs=nums[0];
       for (int i=1;i<nums.length;i++){

        currentsum=Math.max(nums[i],currentsum+nums[i]);
        maxs=Math.max(maxs,currentsum);
        }
        return maxs;


   
    }
}