class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int ini_color = image[sr][sc];

        int[][] ans = image;

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        dfs(sr,sc,ans,delrow,delcol,color,image,ini_color);

        return ans;
    }

    public void dfs(int sr, int sc, int[][] ans, int[] delrow, int[] delcol, int color , int[][] image ,int ini_color){
        ans[sr][sc] = color;

           int n = image.length;
           int m = image[0].length;
             
             for(int i =0; i<4; i++){
                
           int row = sr + delrow[i];
           int col = sc + delcol[i];

           if(row>=0 && row<n && col>=0 && col<m && image[row][col] == ini_color && ans[row][col]!= color){
           
            dfs(row,col,ans,delrow,delcol,color,image,ini_color);
           }
             }

           
    }
}