class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<List<Integer>> tree = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            tree.get(parent[i]).add(i);
        }

        int[] newParent = parent.clone();

        int[] last = new int[26];
        Arrays.fill(last, -1);

        updateParent(0, tree, s, last, newParent);

        List<List<Integer>> newTree = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            newTree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            newTree.get(newParent[i]).add(i);
        }

        int[] ans = new int[n];

        calculateSize(0, newTree, ans);

        return ans;
    }

    private void updateParent(int node,
                              List<List<Integer>> tree,
                              String s,
                              int[] last,
                              int[] newParent) {

        int ch = s.charAt(node) - 'a';

        int previous = last[ch];

        if (previous != -1) {
            newParent[node] = previous;
        }

        last[ch] = node;

        for (int child : tree.get(node)) {
            updateParent(child, tree, s, last, newParent);
        }

        last[ch] = previous;
    }

    private int calculateSize(int node,
                              List<List<Integer>> tree,
                              int[] ans) {

        int size = 1;

        for (int child : tree.get(node)) {
            size += calculateSize(child, tree, ans);
        }

        ans[node] = size;

        return size;
    }
}
