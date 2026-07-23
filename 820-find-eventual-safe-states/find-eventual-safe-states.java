class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            
          int n = graph.length;
        //     int m = graph[0].length;

        // for(int i =0 ; i<n ; i++){
        //     arr.add(new ArrayList<Integer>());
        // }

        // for(int[] graphs : graph){
        //     int u = graphs[0];
        //     int v = graphs[1];
        //     arr.get(u).add(v);
        // }

        

        int[] vis = new int[n];
        int[] pathvis = new int [n];
        int[] check = new int[n];

        ArrayList<Integer> safe = new ArrayList<>();

        for(int i =0 ; i<n; i++){

            if(vis[i] == 0){
                dfs(i,vis,pathvis,check,graph);
            }
        }

        for(int i = 0; i<n; i++){
            if(check[i] == 1){
               safe.add(i);
            }
        }

        return safe;
    
}

    


    private boolean dfs(int i , int[] vis ,int[] pathvis ,int[] check , int[][] graph){
        vis[i] = 1;
        pathvis[i] = 1;
        check[i] = 0;


        for(int it : graph[i]){
            if(vis[it] == 0){
                if(dfs(it,vis,pathvis,check,graph)){
                    
                     return true;
                }
            }
                else if(pathvis[it] == 1){
                    
                    return true;
                }
            
        }
        check[i] = 1;
        pathvis[i] = 0;
        return false;
    }
    }
