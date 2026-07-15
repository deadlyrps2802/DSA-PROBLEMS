class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
      int V = isConnected.length;
    //    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    //    for(int i = 0; i<V; i++){
    //     arr.add(new ArrayList<Integer>());
    //    }


    //    for(int i = 0; i<V; i++){
    //         for(int j = 0; j<V; j++){
    //             if(isConnected[i][j]==1 && i!=j ){
    //                 arr.get(i).add(j);
    //             }
    //         }
    //     }
       

       boolean[] vis = new boolean[V];

       for(int i = 0; i<V; i++){
        if(!vis[i]){
            
            dfs(i,isConnected,vis);
            count++;
        }
       }
      return count;
    }

    public void dfs(int node , int[][] isConnected ,boolean[] vis){
        vis[node] = true;
        // for(Integer i : arr.get(node)){
        //     if(!vis[i]){
        //     dfs(i,arr,vis);
        // }
        // }

        for(int neighbour = 0; neighbour<isConnected.length; neighbour++){
            if(isConnected[node][neighbour] == 1 && !vis[neighbour]){
                dfs(neighbour,isConnected,vis);
            }
        }
    }
}