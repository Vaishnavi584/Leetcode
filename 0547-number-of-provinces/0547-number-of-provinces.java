class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int num = 0;
        boolean vis[] = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                num++;
                dfs(i, isConnected, vis);
            }
        }
        return num;
    }
    public void dfs(int node, int[][] isConnected, boolean vis[]){
        vis[node] = true;
        for(int i = 0; i < isConnected.length; i++){
            if(isConnected[node][i] == 1 && !vis[i]){
                dfs(i, isConnected, vis);
            }
        }
    }
}