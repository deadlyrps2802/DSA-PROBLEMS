class Solution {
   
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
       int[] dp = new int[nums.length+1];
       Arrays.fill(dp,-1);
       int[] dp1 = new int[nums.length+1];
       Arrays.fill(dp1,-1);
         return  Math.max(helper(nums,0,dp) , helper1(nums,1,dp1));
      
    }

    public int helper(int[]nums , int i , int[] dp){
        if(i>=nums.length-1) return 0;
        if(dp[i]!=-1) return dp[i];
       int pick = nums[i] + helper(nums,i+2,dp);
        int skip = helper(nums,i+1,dp);

        return dp[i] = Math.max(pick,skip);
        
    }

    public int helper1(int[] nums , int j, int[] dp1){
        if(j>=nums.length) return 0;
         if(dp1[j]!=-1) return dp1[j];
        int pick1 = nums[j] + helper1(nums,j+2,dp1);
        int skip1 = helper1(nums,j+1,dp1);

        return dp1[j] = Math.max(pick1,skip1);
    }
}