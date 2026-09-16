class Solution {
    public void rotate(int[] nums, int k) {

        int n=nums.length;
         int [] news=new int [n];

        for (int i=0;i<nums.length;i++){
            news[(i+k)%n]=nums[i];

         }
         for (int i=0;i<nums.length;i++){
            nums[i]=news[i];
         }

       

        

        
    }
}