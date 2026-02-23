class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Iterate from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                // If we didn't carry, we can return immediately
                return digits;
            }
            
            // If it was 9, it becomes 0
            digits[i] = 0;
        }

        // If we are here, all digits were 9 (e.g., 999 -> 1000)
        int[] result = new int[n + 1];
        result[0] = 1; 
        // Note: result[1...] are already 0 by default in Java!
        return result;
    }
}