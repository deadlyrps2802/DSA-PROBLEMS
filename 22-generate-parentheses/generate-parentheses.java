class Solution {
    public List<String> generateParenthesis(int n) {
        String op = "";
        int closed = n;
        int open  = n;
        ArrayList<String> res = new ArrayList<>();
        helper(op,closed,open,res);
        return res;
    }

    public void helper(String op , int closed , int open , ArrayList<String> res){
        if(closed == 0 && open == 0){
            res.add(op);
            return;
        }

        if(open!=0){
            helper(op+"(" , closed , open-1, res);
        }

        if(closed>open){
            helper(op+")",closed-1,open,res);
        }
    }
}