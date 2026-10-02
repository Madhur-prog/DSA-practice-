class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        ans[0] = findFirst(nums, target);
        
        if (ans[0] == -1) {
            return ans;
        }

        ans[1] = findLast(nums, target);

        return ans;
    }

    private int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int first = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                first = mid;
                end = mid - 1; 
            } 
            else if (nums[mid] < target) {
                start = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }

        return first;
    }

    private int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int last = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                last = mid;
                start = mid + 1; 
            } 
            else if (nums[mid] < target) {
                start = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }

        return last;
    }
}