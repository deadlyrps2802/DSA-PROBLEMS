class Solution {
    class Pairs{
        int first;
        int second;int dist;
        Pairs(int first, int second, int dist){
            this.first = first;
            this.second = second;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<Pairs> q = new LinkedList<>();

     int[][] dismat = new int[n][m];
      boolean[][] vis = new boolean[n][m];

    

     for(int i = 0; i<n; i++){
        for(int j = 0; j<m; j++){
            if(mat[i][j] == 0){
                vis[i][j] = true;
                q.add(new Pairs(i,j,0));
            }
        }
     }
         int[] delrow = {-1,0,1,0};
      int[] delcol = {0,1,0,-1};

   


        while(!q.isEmpty()){
           int r = q.peek().first;
           int c = q.peek().second;
           int d  = q.peek().dist;

           q.remove();

           dismat[r][c] = d;

           for(int i = 0; i<4; i++){
            int dr = r + delrow[i];
            int dc = c + delcol[i];


            if(dr>=0 && dr<n && dc>=0 && dc<m && !vis[dr][dc]){
                vis[dr][dc] = true;
                q.add(new Pairs(dr,dc,d+1));
            }
           }
        }

           return dismat;
    }
}