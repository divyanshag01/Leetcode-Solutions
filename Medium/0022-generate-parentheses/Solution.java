class Solution {
    public void generate(List<String> ans,String res,int open,int close,int n){
        if(open== n && close == n){
            ans.add(res);
            return;
        }
        if(open<n){
            // res+='(';
            generate(ans,res+'(',open+1,close,n);
        }
        if(close<open){
            // res +=')';
            generate(ans,res+')',open,close+1,n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans =new ArrayList<>();
        String res = "";
        generate(ans,res,0,0,n);
        return ans;
    }
}