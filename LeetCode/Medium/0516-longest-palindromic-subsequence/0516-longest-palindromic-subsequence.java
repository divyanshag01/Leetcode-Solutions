class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String k = sb.reverse().toString();
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return maxLen(s,k,n-1,n-1,dp);
    }
    public int maxLen(String s,String k,int idx1,int idx2,int dp[][]){
        if(idx1<0 || idx2<0){
            return 0;
        }
        if(dp[idx1][idx2]!=-1)return dp[idx1][idx2];
        int pick = 0;
        int notPick = 0;
        if(s.charAt(idx1)==k.charAt(idx2)){
            pick = 1 + maxLen(s,k,idx1-1,idx2-1,dp);
        }
        notPick = Math.max(maxLen(s,k,idx1-1,idx2,dp),maxLen(s,k,idx1,idx2-1,dp));
        return dp[idx1][idx2] = Math.max(pick,notPick);
    }
}