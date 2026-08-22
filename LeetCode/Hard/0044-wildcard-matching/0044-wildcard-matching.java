class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];
        for(int i = 1;i<m+1;i++){
            if(p.charAt(i-1)=='*')dp[0][i] = true;
            else break;
        }
        dp[0][0] = true;
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<m+1;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }
        // return check(s,p,s.length()-1,p.length()-1,dp);
    // }
    // public boolean check(String s,String p,int idx1,int idx2,int dp[][]){
    //     if(idx1<0 && idx2<0) return true;
    //     if(idx1>=0 && idx2<0) return false;
    //     if(idx1<0 && idx2>=0){
    //         for(int i = idx2;i>=0;i--){
    //             if(p.charAt(i)!='*')return false;
    //         }
    //         return true;
    //     }
    //     if(dp[idx1][idx2]!=-1)return dp[idx1][idx2]==1;
    //     if(s.charAt(idx1)==p.charAt(idx2) || p.charAt(idx2)=='?'){
    //         if(check(s,p,idx1-1,idx2-1,dp)){
    //             dp[idx1][idx2] = 1;
    //         }else{
    //             dp[idx1][idx2] = 0;
    //         }
    //         return dp[idx1][idx2]==1;
    //     }
    //     if(p.charAt(idx2)=='*'){
    //         if(check(s,p,idx1-1,idx2,dp) || check(s,p,idx1,idx2-1,dp)){
    //          dp[idx1][idx2] = 1;
    //         }else{
    //             dp[idx1][idx2] = 0;
    //         }
    //         return dp[idx1][idx2]==1;
    //     }
    //     dp[idx1][idx2] = 0;
    //     return false;
       
    // }
}