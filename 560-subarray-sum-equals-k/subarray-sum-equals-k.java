class Solution {
    public int subarraySum(int[] nums, int k) {
        int preSum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

         int cnt = 0;
        for(int i = 0; i<nums.length; i++){
            preSum += nums[i];
            int remove = preSum - k;
            cnt += map.getOrDefault(remove,0);
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }

        return cnt;
    }
}