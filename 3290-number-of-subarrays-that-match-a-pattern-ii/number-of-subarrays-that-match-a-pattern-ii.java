class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;

        // Step 1: nums ke transitions nikal kar text array banao
        // text array ki length (n - 1) hogi
        int[] text = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            text[i] = Integer.compare(nums[i + 1], nums[i]);
        }

        // Step 2: Pattern ka LPS (Longest Prefix Suffix) array compute karo
        int[] lps = buildLPS(pattern);

        // Step 3: KMP algorithm se text me pattern match count karo
        int count = 0;
        int i = 0; // Pointer for text
        int j = 0; // Pointer for pattern

        while (i < text.length) {
            // Agar elements match kar rahe hain, dono pointers aage badhao
            if (text[i] == pattern[j]) {
                i++;
                j++;
            }

            // Pura pattern match ho gaya
            if (j == m) {
                count++;
                // Agle match ke liye smart jump (overlapping patterns handle karne ke liye)
                j = lps[j - 1];
            } 
            // Mismatch case
            else if (i < text.length && text[i] != pattern[j]) {
                if (j != 0) {
                    // Pattern pointer peeche fallback karega, text pointer (i) wahi rahega
                    j = lps[j - 1];
                } else {
                    // Agar pehle hi element par mismatch hua, text me aage badho
                    i++;
                }
            }
        }

        return count;
    }

    // LPS Table helper function
    private int[] buildLPS(int[] pattern) {
        int m = pattern.length;
        int[] lps = new int[m];
        int len = 0; // Length of previous longest prefix suffix
        int i = 1;

        lps[0] = 0; // Single element ka LPS hamesha 0 hota hai

        while (i < m) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}