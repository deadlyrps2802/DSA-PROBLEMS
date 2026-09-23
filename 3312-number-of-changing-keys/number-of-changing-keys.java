class Solution {
    public int countKeyChanges(String s) {
        String str = s.toLowerCase();
          
          int count = 0 ;


        for(int i = 1; i<s.length(); i++){
            char ch = str.charAt(i);
            char ch1 = str.charAt(i-1);

            if(ch - ch1 > 0 || ch - ch1 < 0) count++;
        }
       
       return count;
    }
}