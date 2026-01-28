class Solution {
    public List<String> letterCasePermutation(String s) {
        int i = 0;
        String op = "";
        ArrayList<String> res = new ArrayList<>();
        helper(s,op,res,i);
        return res;
    }

    public void helper(String inp, String op, ArrayList<String> res , int i){

        if(i==inp.length()){
            res.add(op);
            return;
        }
         
         char ch = inp.charAt(i);
        
        if(Character.isLetter(ch)){
             helper(inp , op+Character.toUpperCase(ch), res, i+1);
             helper(inp , op+Character.toLowerCase(ch), res, i+1);
        }
        else{
            op+=ch;
            helper(inp,op,res,i+1);
        }
    }
}