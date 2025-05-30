class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        List<int[]> st = new ArrayList<>();
        int rows = maze.length;
        int cols = maze[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] == '.' && (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && !isEquals(new int[]{i, j}, entrance)) {
                    st.add(new int[]{i, j, 0});
                }
            }
        }
        return bfs(st, maze, entrance);
    }

    private boolean isEquals(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    private int bfs(List<int[]> st, char[][] maze, int[] start) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Set<String> visited = new HashSet<>();

        while (!st.isEmpty()) {
            int[] cur = st.remove(0);
            int row = cur[0], col = cur[1], len = cur[2];
            visited.add(row + "," + col);

            for (int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];

                if (isEquals(new int[]{r, c}, start)) return len + 1;
                if (r < 0 || c < 0 || r >= maze.length || c >= maze[0].length || maze[r][c] == '+' || visited.contains(r + "," + c)) continue;

                st.add(new int[]{r, c, len + 1});
                visited.add(r + "," + c);
            }
        }
        return -1;
    }
}