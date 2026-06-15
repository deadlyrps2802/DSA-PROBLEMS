class Solution {
    static int []dp;
    public int tribonacci(int n) {
        dp = new int[n+1];
        
        return trib(n);
    }

    public int trib(int n){
        if(n==0 || n==1 ) return n;
        if(n==2) return 1;
        if(dp[n]!=0) return dp[n];
        return dp[n] = trib(n-1)+trib(n-2)+trib(n-3);
    }
}