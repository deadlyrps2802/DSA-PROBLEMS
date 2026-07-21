class Solution {
    
    private boolean checkDFS(int node, int col, int[][] graph, int[] color) {
        color[node] = col;

        for (int neighbor : graph[node]) {
            // If neighbor is uncolored, make recursive DFS call with opposite color (1 - col)
            if (color[neighbor] == -1) {
                if (!checkDFS(neighbor, 1 - col, graph, color)) {
                    return false;
                }
            } 
            // If neighbor is already colored with the same color -> Conflict
            else if (color[neighbor] == col) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        // Initialize all nodes as uncolored (-1)
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }

        // Handle disconnected graphs
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!checkDFS(i, 0, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}