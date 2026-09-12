class Solution {
    public int countVowelSubstrings(String word) {
       int ans = 0;
       for(int left = 0; left<word.length(); left++){
        Set<Character> set = new HashSet<>();
        for(int end = left; end < word.length(); end ++){
            char ch = word.charAt(end);

            if(!isVowel(ch)) break;

            set.add(ch);

            if(set.size() == 5){
                ans++;
            }
        }
       } 

       return ans;
    }

    private boolean isVowel(char c){
        return c == 'a' || c== 'e'|| c== 'i' || c== 'o'|| c == 'u';
         
        
    }
}