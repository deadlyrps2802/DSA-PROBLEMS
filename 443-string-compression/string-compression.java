class Solution {
    public int compress(char[] chars) {
        int i =0;
        String str = "";
      
      while(i<chars.length){
        char current = chars[i];
        int count = 0;

        while(i<chars.length && current == chars[i]){
         i++;
         count++;
        }

        str +=  current;

        if(count>1){
            str+= count;
        }
      }

    

    for(int k =0; k<str.length(); k++){
        chars[k] = str.charAt(k);
        }

        return str.length();
}
}