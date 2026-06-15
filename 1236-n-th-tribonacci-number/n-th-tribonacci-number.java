class Solution {
    // static int []dp;
    public int tribonacci(int n) {
        // dp = new int[n+1];
        
        // return trib(n);

        int[] dp = new int[n+1];
        if(n==0||n==1) return n;
        if(n==2) return 1;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }

    // public int trib(int n){
    //     if(n==0 || n==1 ) return n;
    //     if(n==2) return 1;
    //     if(dp[n]!=0) return dp[n];
    //     return dp[n] = trib(n-1)+trib(n-2)+trib(n-3);
    // }
}