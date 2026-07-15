class Solution {

    class Pairs{
        int first;
        int second;
        Pairs(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
          int count = 0;

        for(int i =0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(!vis[i][j]  && grid[i][j] == '1'){
                    bfs(i,j,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }

    public  void bfs(int i , int j , boolean[][] vis, char[][] grid){
        vis[i][j] = true;
        Queue<Pairs> q = new LinkedList<>();
          q.add(new Pairs(i,j));

          int n = grid.length;
          int m = grid[0].length;

        
        while(!q.isEmpty()){
            int row =q.peek().first;
            int col = q.peek().second;

            q.remove();

            for(int k = -1; k<=1; k++){
                for(int l =-1 ; l<=1; l++){

                    if(Math.abs(k) + Math.abs(l)==1){

                        int nrow = row + k;
                        int ncol = col + l;

                        if(nrow >= 0 && nrow<n && ncol>= 0 && ncol <m && !vis[nrow][ncol]  && grid[nrow][ncol] == '1'){
                            vis[nrow][ncol] = true;
                            q.add(new Pairs(nrow,ncol));
                        }
                    }
                }
            }
       
              

        }
        
    }
}