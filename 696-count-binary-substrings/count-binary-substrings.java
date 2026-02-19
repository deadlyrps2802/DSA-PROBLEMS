class Solution {
    public int countBinarySubstrings(String s) {
        int count  = 0;
        int pgl = 0 ;
        int cgl = 1;
          

      for(int i = 1; i < s.length(); i++){
        if(s.charAt(i) == s.charAt(i-1)){
            cgl++;
        }
             else{
         count += Math.min(cgl,pgl);

         pgl = cgl;
         cgl = 1;
      }
        
    }
    return count + Math.min(cgl,pgl);
}
}