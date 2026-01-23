class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
         List<String> result = new ArrayList<>();

           int i =0;
           while(i< words.length){
               int j =i+1;
               int linelength = words[i].length(); // length of each word that is going to be added in the line

               // case 1: how many words fit in the line

               while(j<words.length && (linelength + words[j].length() + (j-i)) <= maxWidth){
                   linelength += words[j].length();
                   j++;

               }

               int numwords = j-i;
               int gaps = numwords -1;
               StringBuilder sb = new StringBuilder();


            // case2: left justification

               if(j== words.length || gaps == 0){
                   for(int  k=i; k<j; k++){
                       sb.append(words[k]);
                       if(k<j-1) sb.append(" ");
                   }
                   while(sb.length() < maxWidth) sb.append(" ");
               }
               // case3 : Normal justification
               else {

                   int totalspaces = maxWidth -  linelength;
                   int spacesrequired = totalspaces / gaps;
                   int extraspaces = totalspaces % gaps;
                   for(int k =i ; k<j; k++){
                       sb.append(words[k]);
                       if(k<j-1){
                           int spaces_add = spacesrequired + (k-i < extraspaces ? 1: 0);
                           for(int s=0; s<spaces_add; s++) sb.append(" ");
                       }
                   }
               }


          result.add(sb.toString());
               i=j;
        }
           return result;
    }
}