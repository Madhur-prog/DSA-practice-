class Solution {
    public int countRotations(String s, int k) {
        int n = s.length(), ans = 0;

        for (int sh = 0; sh < n; sh++) {
            String t = s.substring(sh) + s.substring(0, sh);

            int cnt = 0;
            for (int i = 0; i < n - 1; i++) {
                if (t.charAt(i) == t.charAt(i + 1)) cnt++;
            }

            if (cnt == k) ans++;
        }

        return ans;
    }
}