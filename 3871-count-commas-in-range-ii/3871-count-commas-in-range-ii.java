class Solution {
    public long countCommas(long n) {
        long ans = 0;

        for (int c = 1; c <= 5; c++) {
            long l = pow10(3 * c);
            long r = Math.min(n, pow10(3 * (c + 1)) - 1);

            if (n >= l) {
                ans += (r - l + 1) * c;
            }
        }

        return ans;
    }

    private long pow10(int p) {
        long x = 1;
        while (p-- > 0) x *= 10;
        return x;
    }
}