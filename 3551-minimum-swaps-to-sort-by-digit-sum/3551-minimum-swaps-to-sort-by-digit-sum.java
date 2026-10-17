class Solution {

    public int digsum(int num) {
        int sum = 0;

        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();

        
        Arrays.sort(sorted);

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> {
            if (digsum(a) != digsum(b)) {
                return Integer.compare(digsum(a), digsum(b));
            }
            return Integer.compare(a, b);
        });

       
        for (int i = 0; i < n; i++) {
            sorted[i] = arr[i];
        }
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mpp.put(nums[i], i);
        }

        int swapcnt = 0;

        for (int i = 0; i < n; i++) {
            int expected = sorted[i];
            int curr = nums[i];

            if (expected == curr) {
                continue;
            }

            int indx = mpp.get(expected);

            int temp = nums[i];
            nums[i] = nums[indx];
            nums[indx] = temp;

         
            mpp.put(expected, i);
            mpp.put(curr, indx);

            swapcnt++;
        }

        return swapcnt;
    }
}