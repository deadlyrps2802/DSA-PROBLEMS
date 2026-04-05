class Solution {
    public class Pairs{
        int row;
        int col;

        Pairs(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int numEnclaves(int[][] grid) {
        int count = 0;
        Queue<Pairs> q = new LinkedList<>();
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(i==0 || i==grid.length -1 || j==0 || j == grid[0].length-1){
                    if(grid[i][j] == 1){
                        q.add(new Pairs(i,j));
                        grid[i][j] = -1;
                    }
                }
            }
        }

        while(q.size()>0){
            Pairs front = q.remove();
            int row = front.row , col = front.col;

            if(col-1>=0 && grid[row][col-1] == 1){
                q.add(new Pairs(row,col-1));
                grid[row][col-1] = -1;
            }
            if(row-1>=0 && grid[row-1][col] == 1){
                q.add(new Pairs(row-1,col));
                grid[row-1][col] = -1;
            }
            if(col+1<grid[0].length && grid[row][col+1] == 1){
                q.add(new Pairs(row,col+1));
                grid[row][col+1] = -1;
            }
            if(row+1<grid.length && grid[row+1][col] == 1){
                q.add(new Pairs(row+1,col));
                grid[row+1][col] = -1;
            }

        }

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1) count = count +1;
            }
        }

        return count;
    }
}