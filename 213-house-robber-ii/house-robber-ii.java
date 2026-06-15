class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);

        int max1 = helper(0,nums.length-2,nums);
        int max2 = helper(1,nums.length-1,nums);

        return Math.max(max1,max2);
    }

    public int helper( int i , int j , int[] nums){
      int n = j-i+1;
      int [] dp = new int[n];

      dp[0] = nums[i];
      dp[1] = Math.max(nums[i] , nums[i+1]);
     
        for(int k = 2 ; k<n ; k++){
            dp[k] = Math.max(nums[i+k] + dp[k-2] , dp[k-1]);
        }

        return dp[n-1];

    }
}