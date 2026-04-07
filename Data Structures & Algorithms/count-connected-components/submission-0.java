class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int count = n;

        for (int[] edge : edges) {
            int pu = find(parent, edge[0]);
            int pv = find(parent, edge[1]);

            if (pu != pv) {
                parent[pu] = pv;
                count--;
            }
        }

        return count;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}