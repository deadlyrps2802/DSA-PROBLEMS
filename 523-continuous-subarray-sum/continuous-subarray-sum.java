class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> rem = new HashMap<>();
        rem.put(0,-1);
        int running_sum = 0; 

        for(int i = 0; i<nums.length; i++){
            running_sum += nums[i];

            int remainder = running_sum % k;
              
              if(!rem.containsKey(remainder)){
                rem.put(remainder,i);
              }
              else if( i - rem.get(remainder) > 1){
                return true;
              }
         }

         return false;
    }
}