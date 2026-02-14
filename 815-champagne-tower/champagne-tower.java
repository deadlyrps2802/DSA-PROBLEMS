class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        

        double[][] tower = new double[102][102];

        tower[0][0] = (double) poured;

        for(int r = 0; r<= query_row; r++){
            for(int c  = 0; c<=r; c++){
                double overflow = (tower[r][c] -1.0)/2.0;

                if(overflow>0){
                    tower[r+1][c] += overflow;
                    tower[r+1][c+1] += overflow; 
                }
            }
        }

        return Math.min(1.0 , tower[query_row][query_glass]);
    }
}