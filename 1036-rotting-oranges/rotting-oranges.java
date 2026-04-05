class Solution {
    public class Triplet{
        int row;
        int col;
         int time;

         Triplet(int row, int col , int time){
            this.row = row;
            this.col = col;
            this.time = time;
         }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Triplet> q = new LinkedList<>();
        for(int i =0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new Triplet(i,j,0));
                }
            }
        }

        int maxtime = 0; 
        
        while(q.size()>0){
            Triplet front = q.remove();
            int row = front.row , col = front.col , time = front.time;

            maxtime = Math.max(maxtime,time);

            if(col-1>=0 && grid[row][col-1] == 1){
                q.add(new Triplet(row,col-1,time+1));
                grid[row][col-1] = 2;
            }
             if(col+1<grid[0].length && grid[row][col+1] == 1){
                q.add(new Triplet(row,col+1,time+1));
                grid[row][col+1] = 2;
            }
             if(row-1>=0 && grid[row-1][col] == 1){
                q.add(new Triplet(row-1,col,time+1));
                grid[row-1][col] = 2;
            }
             if(row+1<grid.length && grid[row+1][col] == 1){
                q.add(new Triplet(row+1,col,time+1));
                grid[row+1][col] = 2;
            }
        }

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return maxtime;
    }
}