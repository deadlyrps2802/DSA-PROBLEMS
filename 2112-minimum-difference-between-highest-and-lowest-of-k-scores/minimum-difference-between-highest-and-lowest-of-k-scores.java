class Solution {
    public int minimumDifference(int[] nums, int k) {
        // If we only need to pick 1 student, the difference is always 0
        if (k == 1) return 0;

        // 1. Sort the array so closest numbers are adjacent
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        // 2. Slide a window of size k through the array
        // The window starts at i and ends at i + k - 1
        for (int i = 0; i <= nums.length - k; i++) {
            int currentDiff = nums[i + k - 1] - nums[i];
            
            // 3. Update the minimum difference found
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
            }
        }

        return minDiff;
    }
}
