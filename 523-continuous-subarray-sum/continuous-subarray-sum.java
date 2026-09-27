
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Map store karega: <remainder, earliest_index>
        Map<Integer, Integer> map = new HashMap<>();
        
        // Base case: 0 remainder at index -1 (jab shuru se hi sum divisible ho jaye)
        map.put(0, -1);
        
        int runningSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int remainder = runningSum % k;
            
            // Negative numbers ke case ke liye modulo adjust karna safe rehta hai
            if (remainder < 0) remainder += k;
            
            if (map.containsKey(remainder)) {
                // Check karo subarray length at least 2 hai ya nahi
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                // Sirf pehli baar remainder aane par index daalo taaki window maximum rahe
                map.put(remainder, i);
            }
        }
        
        return false;
    }
}