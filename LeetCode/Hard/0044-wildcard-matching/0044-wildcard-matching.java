class Solution {
    public boolean isMatch(String s, String p) {
        int dp[][] = new int[s.length()][p.length()];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return check(s,p,s.length()-1,p.length()-1,dp);
    }
    public boolean check(String s,String p,int idx1,int idx2,int dp[][]){
        if(idx1<0 && idx2<0) return true;
        if(idx1>=0 && idx2<0) return false;
        if(idx1<0 && idx2>=0){
            for(int i = idx2;i>=0;i--){
                if(p.charAt(i)!='*')return false;
            }
            return true;
        }
        if(dp[idx1][idx2]!=-1)return dp[idx1][idx2]==1;
        if(s.charAt(idx1)==p.charAt(idx2) || p.charAt(idx2)=='?'){
            if(check(s,p,idx1-1,idx2-1,dp)){
                dp[idx1][idx2] = 1;
            }else{
                dp[idx1][idx2] = 0;
            }
            return dp[idx1][idx2]==1;
        }
        if(p.charAt(idx2)=='*'){
            if(check(s,p,idx1-1,idx2,dp) || check(s,p,idx1,idx2-1,dp)){
             dp[idx1][idx2] = 1;
            }else{
                dp[idx1][idx2] = 0;
            }
            return dp[idx1][idx2]==1;
        }
        dp[idx1][idx2] = 0;
        return false;
       
    }
}