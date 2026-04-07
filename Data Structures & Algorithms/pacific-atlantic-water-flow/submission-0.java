class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        // Pacific (top row + left col)
        for (int i = 0; i < m; i++) dfs(heights, pac, i, 0);
        for (int j = 0; j < n; j++) dfs(heights, pac, 0, j);

        // Atlantic (bottom row + right col)
        for (int i = 0; i < m; i++) dfs(heights, atl, i, n - 1);
        for (int j = 0; j < n; j++) dfs(heights, atl, m - 1, j);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j) {
        int m = heights.length, n = heights[0].length;

        if (visited[i][j]) return;
        visited[i][j] = true;

        int[] dir = {0, 1, 0, -1, 0};

        for (int d = 0; d < 4; d++) {
            int ni = i + dir[d];
            int nj = j + dir[d + 1];

            if (ni >= 0 && nj >= 0 && ni < m && nj < n &&
                heights[ni][nj] >= heights[i][j]) {
                dfs(heights, visited, ni, nj);
            }
        }
    }
}