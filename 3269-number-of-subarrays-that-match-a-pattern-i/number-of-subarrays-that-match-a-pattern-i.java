class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;

        int cnt = 0;

        for(int i = 0; i<= n-m-1 ; i++){
            boolean match = true;
            for(int k = 0; k<m; k++){
            
            int next = nums[i+k+1];
            int curr = nums[i+k];

            int relation = Integer.compare(next,curr);

            if(relation != pattern[k]){
                match = false;
                break;
            }

            }
            if(match){
                cnt++;
            }
        }
       return cnt;

    }
}