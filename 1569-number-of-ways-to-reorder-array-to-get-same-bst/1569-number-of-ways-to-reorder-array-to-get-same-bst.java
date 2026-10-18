class Solution {

    private static final long MOD = 1_000_000_007;
    private long[][] combs;

    public int numOfWays(int[] nums) {

        int n = nums.length;
        combs = new long[n][n];

        for (int i = 0; i < n; i++) {
            combs[i][0] = 1;
            combs[i][i] = 1;
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {

                combs[i][j] =
                    (combs[i - 1][j - 1]
                    + combs[i - 1][j]) % MOD;
            }
        }

        List<Integer> numbers = new ArrayList<>();

        for (int num : nums) {
            numbers.add(num);
        }
        long totalWays = countWays(numbers);

        return (int) ((totalWays - 1 + MOD) % MOD);
    }

    private long countWays(List<Integer> numbers) {

        int n = numbers.size();
        if (n < 3) {
            return 1;
        }

        int root = numbers.get(0);

        List<Integer> leftSubtree = new ArrayList<>();
        List<Integer> rightSubtree = new ArrayList<>();
        for (int i = 1; i < n; i++) {

            int value = numbers.get(i);

            if (value < root) {
                leftSubtree.add(value);
            } else {
                rightSubtree.add(value);
            }
        }
        long leftWays = countWays(leftSubtree);
        long rightWays = countWays(rightSubtree);
        int leftSize = leftSubtree.size();

        long waysToArrange = combs[n - 1][leftSize];
        long totalWays = waysToArrange * leftWays % MOD;
        totalWays = totalWays * rightWays % MOD;

        return totalWays;
    }
}
