import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {

          HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        int longest = 0;
        Integer[] arr = set.toArray(new Integer[0]);
        
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            
           
            if (!set.contains(num - 1)) {
                
                int currentNum = num;
                int count = 1;
                
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                
                longest = Math.max(longest, count);
            }
        }
        
        return longest;
    }
}