class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        final var visited = new boolean[rooms.size()];
        visit(rooms, visited, 0);
        for (final var x : visited) {
            if (!x) {
                return false;
            }
        }
        return true;
    }

    private void visit(final List<List<Integer>> rooms, final boolean[] visited, final int current) {
        visited[current] = true;
        for (final var k : rooms.get(current)) {
            if (!visited[k]) {
                visit(rooms, visited, k);
            }
        }
    }
}