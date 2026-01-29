class Solution {
    public List<String> validStrings(int n) {
        String op = "";
     
        ArrayList<String> result = new ArrayList<>();

        helper(op,n,result);
        return result;
    }

    public void helper(String op , int n , ArrayList<String> res){
        if(n==0){
            res.add(op);
            return;
        }
      helper(op+"1" , n-1 , res);
      if(op.length()==0 || op.charAt(op.length()-1)=='1'){
        helper(op+"0" , n-1 , res);
      }
         
    
    }
}