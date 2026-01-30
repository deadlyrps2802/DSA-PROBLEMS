class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        // Pointer for the position of the last unique element found
        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {
            // If we find a new unique element
            if (nums[fast] != nums[slow]) {
                slow++;             // Move to the next slot
                nums[slow] = nums[fast]; // Update the slot with the unique value
            }
        }

        // The number of unique elements is the index 'slow' + 1
        return slow + 1;
    }
}