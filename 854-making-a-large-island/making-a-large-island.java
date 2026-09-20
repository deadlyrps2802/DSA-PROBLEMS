class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);

     // DisjointSet Creation : ------>
        for(int row = 0; row < n ; row++){
            for(int col = 0; col<n; col ++){
                if(grid[row][col] == 0) continue;

                int dr[] = {-1,0,1,0};
                int dc[] = {0,-1,0,1};

                for(int indx = 0; indx<4; indx++){
                    int newr = row + dr[indx];
                    int newc = col + dc[indx];
                    if(newr >= 0 && newr < n && newc >= 0 && newc<n && grid[newr][newc] == 1 ){
                        int Nodeno = row * n + col;
                        int adjNodeno = newr * n + newc;

                        ds.UnionBySize(Nodeno,adjNodeno);
                    }
                }
            }
        }
 
     // Converting atmost one 0 to 1 and calculating size of largest island

     int max = 0;
      
       for(int row = 0; row < n ; row++){
            for(int col = 0; col<n; col ++){
                if(grid[row][col] == 1) continue;

                int dr[] = {-1,0,1,0};
                int dc[] = {0,-1,0,1};

              HashSet<Integer> set = new HashSet<>();

                for(int indx = 0; indx<4; indx++){
                    int newr = row + dr[indx];
                    int newc = col + dc[indx];
                    if(newr >= 0 && newr < n && newc >= 0 && newc<n && grid[newr][newc] == 1 ){
                        set.add(ds.findUPar(newr * n + newc));
                    }
                }
            

               int total = 0; 

               for(Integer parents : set){
                total += ds.size[parents];
             }

               max = Math.max( max , total +1 ) ;

            }
       }

        for(int cell = 0; cell < n*n ; cell++){
        max = Math.max(max,ds.size[ds.findUPar(cell)]);
    }
      return max;
    }
}



class DisjointSet{
    int[] parent;
    int[] size;

    public DisjointSet(int n){
        parent = new int[n+1];
        size = new int[n+1];

        for(int i = 0; i<=n ; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUPar(int node){
        if(node == parent[node]) return node;

        return parent[node] = findUPar(parent[node]);
    }

    public void UnionBySize( int u , int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
  
       if (ulp_u == ulp_v) return;
  
  
        if(size[ulp_u] < size[ulp_v]){
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];

        }
        else{
             parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}