class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n=nums.length;

       HashSet<Integer> set = new HashSet<>();

        for (int i=0;i<nums.length;i++){
            set.add(nums[i]);

           }
            int mul=k;
           while(set.contains(mul)){
              mul += k;

        }
        return mul;


        
    }
}