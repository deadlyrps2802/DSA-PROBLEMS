class Solution {
    public int longestBalanced(String s) {
        
        int n = s.length();
        int maxLen = 0;

        // --- Case 1: Exactly 1 distinct character ---
        int currentRun = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                currentRun++;
            } else {
                currentRun = 1;
            }
            maxLen = Math.max(maxLen, currentRun);
        }

        // --- Case 2: Exactly 2 distinct characters ---
        maxLen = Math.max(maxLen, solveTwoChars(s, 'a', 'b', 'c', n));
        maxLen = Math.max(maxLen, solveTwoChars(s, 'a', 'c', 'b', n));
        maxLen = Math.max(maxLen, solveTwoChars(s, 'b', 'c', 'a', n));

        // --- Case 3: Exactly 3 distinct characters ---
        maxLen = Math.max(maxLen, solveThreeChars(s));

        return maxLen;
    }

    // Optimization: Array reset logic removed to prevent O(N^2)
    private int solveTwoChars(String s, char c1, char c2, char forbidden, int n) {
        int max = 0;
        int[] firstOccurrence = new int[2 * n + 1];
        // Initialize with -2 (indicating not seen)
        Arrays.fill(firstOccurrence, -2);
        
        // Offset to handle negative indices
        int offset = n;
        
        // Initial state logic
        int diff = 0;
        int start = 0; // Tracks the start of the current valid segment
        
        // Initial setup for the very first segment
        // diff 0 is conceptually seen at index -1
        // But since we use array checks, we handle diff=0 specially or init it carefully
        // Trick: Only init the global array once. Use 'start' to validate.
        
        // We cannot pre-fill diff=0 because 'start' moves.
        // Logic inside loop handles it.
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (c == forbidden) {
                // Segment break. Reset diff and move start pointer.
                // We DO NOT clear the array (expensive). We just ignore old values.
                start = i + 1;
                diff = 0;
            } else {
                if (c == c1) diff++;
                else if (c == c2) diff--;
                
                // Special check for balanced state (count1 == count2) within current segment
                if (diff == 0) {
                    // Valid balanced substring from 'start' to 'i'
                    max = Math.max(max, i - start + 1);
                } else {
                    int idx = firstOccurrence[diff + offset];
                    
                    // Valid check: Index must be >= start of current segment (minus 1 logic handled by diff 0 case above)
                    // Actually, if we stored diff 'd' at index 'k', the substring is (k, i].
                    // k must be >= start (technically >= start-1, but diff!=0 implies we are inside)
                    
                    if (idx >= start) {
                        max = Math.max(max, i - idx);
                    } else {
                        // Value in array is old (from previous segment), overwrite it
                        firstOccurrence[diff + offset] = i;
                    }
                }
            }
        }
        return max;
    }

    // 3 Chars logic remains same (O(N) with Map is fine as forbidden chars don't exist here)
    private int solveThreeChars(String s) {
        int max = 0;
        int n = s.length();
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1); // 0L represents (0,0) diff

        int a = 0, b = 0, c = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') a++;
            else if (ch == 'b') b++;
            else if (ch == 'c') c++;

            long key = (((long)(a - b)) << 32) | ((b - c) & 0xFFFFFFFFL);

            if (map.containsKey(key)) {
                max = Math.max(max, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }
        return max;
    }
}
    