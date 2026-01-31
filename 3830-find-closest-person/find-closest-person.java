class Solution {
    public int findClosest(int x, int y, int z) {
    
    int diff1 = z-x;
    if(diff1<0){
        diff1 *= -1;
    }
    int diff2 = z-y;
     if(diff2<0){
        diff2 *= -1;
    
    }
    if(diff1>diff2) return 2;
    else if(diff2>diff1) return 1;
    else return 0;
}
}