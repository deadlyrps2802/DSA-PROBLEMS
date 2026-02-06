class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int maxWindow = 0;

        // Step 2: Sliding Window
        for (int right = 0; right < n; right++) {
            // Agar condition fail ho rahi hai, left ko aage badhao
            while (nums[right] > (long) k * nums[left]) { 
                left++;
            }
            // Max elements jo hum rakh sakte hain
            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        // Step 3: Total - Max kept
        return n - maxWindow;
    }
}
    