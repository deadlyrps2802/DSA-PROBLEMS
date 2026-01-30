class Solution {
    public int strStr(String haystack, String needle) {
int nLen = needle.length();
int hLen = haystack.length();

        // If needle is empty, technically the first occurrence is index 0
        if (nLen == 0) return 0;
        
        // No need to check if needle is longer than haystack
        for (int i = 0; i <= hLen - nLen; i++) {
            // Check if the substring starting at i matches needle
            int j;
            for (j = 0; j < nLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            
            // If we completed the inner loop, we found the match
            if (j == nLen) {
                return i;
            }
        }

        return -1;
    }
}