class Solution {
    public int longestBalanced(String s) {
       
        int n = s.length();
        int maxLen = 0;

        // Outer loop: Substring ka start point
        for (int i = 0; i < n; i++) {
            // Frequency array for current window [i...j]
            int[] freq = new int[26];
            
            // Inner loop: Substring ka end point
            for (int j = i; j < n; j++) {
                // Current character ki frequency badhao
                char c = s.charAt(j);
                freq[c - 'a']++;
                
                // Check karo agar current window balanced hai
                if (isBalanced(freq)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        
        return maxLen;
    }

    // Helper function to check if frequencies are same
    private boolean isBalanced(int[] freq) {
        int targetCount = -1;
        
        for (int count : freq) {
            if (count > 0) {
                // Agar pehla non-zero count milta hai, usse target set karo
                if (targetCount == -1) {
                    targetCount = count;
                } 
                // Agar agla koi non-zero count match nahi karta, toh balanced nahi hai
                else if (count != targetCount) {
                    return false;
                }
            }
        }
        return true;
    }
}