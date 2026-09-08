class Solution {
    public int countCommas(int n) {
        int ans = 0;

        long st = 1000;
        int c = 1;

        while (st <= n) {
            long en = Math.min((long)n, st * 1000 - 1);

            ans += (int)((en - st + 1) * c);

            st *= 1000;
            c++;
        }

        return ans;
    }
}