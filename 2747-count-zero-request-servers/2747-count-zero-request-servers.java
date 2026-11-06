class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int m = queries.length;
        Integer[] ids = new Integer[m];

        for (int i = 0; i < m; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (a, b) -> queries[a] - queries[b]);

        int[] ans = new int[m];
        int[] cnt = new int[n + 1];

        int left = 0;
        int right = 0;
        int active = 0;
        for (int i : ids) {

            int q = queries[i];
            while (right < logs.length && logs[right][1] <= q) {

                int id = logs[right][0];

                if (cnt[id] == 0) {
                    active++;
                }

                cnt[id]++;
                right++;
            }

            while (left < right && logs[left][1] < q - x) {

                int id = logs[left][0];

                cnt[id]--;

                if (cnt[id] == 0) {
                    active--;
                }

                left++;
            }

            ans[i] = n - active;
        }

        return ans;
    }
}