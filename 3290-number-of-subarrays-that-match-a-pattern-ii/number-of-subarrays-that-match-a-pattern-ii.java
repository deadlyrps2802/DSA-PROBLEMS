class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        
        int[] txt = new int[n-1];

        for(int i = 1; i<n; i++){
            txt[i-1] = Integer.compare(nums[i],nums[i-1]);
        }


        int[] LPS = new int[m];

        int i = 1;
        int prevLPS = 0;
        LPS[0] = 0;

        while(i<pattern.length){
            if(pattern[i] == pattern[prevLPS]){
                LPS[i] = prevLPS + 1;
                i++;
                prevLPS++;
            }
            else if(prevLPS==0){
               LPS[i] = 0;
               i++;
            }
            else{
                prevLPS = LPS[prevLPS-1];
            }
        }

        return count(txt,pattern,LPS);
    }

    private int count(int[] txt, int[] pattern, int[] LPS){
        int count = 0;
        int i = 0;
        int j = 0;

        while(i<txt.length){
            if(txt[i] == pattern[j]){
                i++;
                j++;
                if(j==pattern.length){
                    count++;
                    j = LPS[j-1];
            }
                
            }
            else if(j==0){
                i++;
            }
            else{
                j = LPS[j-1];
            }
           
           
        }
        return count;
    }
}