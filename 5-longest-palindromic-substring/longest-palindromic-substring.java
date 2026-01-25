class Solution {
   
    public String longestPalindrome(String s) {
 
      int start = 0;
      int end = 0;
    for(int i=0 ; i<s.length(); i++){
        int len = check(s,i,i);
        int len2 = check(s,i,i+1);
     
    int maxlen = Math.max(len,len2);
        if(maxlen>(end-start)){
            start = i - (maxlen -1)/2;
            end = i + maxlen/2;
        }
    }  

    return s.substring(start ,end+1);  
}

 public int check(String s , int l , int r){
    while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
        l--;
        r++;
    }
    return r-l-1;
 }
}