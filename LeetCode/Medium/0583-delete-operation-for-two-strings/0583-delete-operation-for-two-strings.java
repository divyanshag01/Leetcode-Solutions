class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int len = maxLen(word1,word2,n-1,m-1,dp);
        return (n-len)+(m-len);
    }
    public int maxLen(String s,String k,int idx1,int idx2,int dp[][]){
        if(idx1<0 || idx2<0) return 0;
        if(dp[idx1][idx2]!=-1)return dp[idx1][idx2];
        int pick = 0;
        if(s.charAt(idx1)==k.charAt(idx2)){
            pick = 1+maxLen(s,k,idx1-1,idx2-1,dp);
        }
        int notPick = Math.max(maxLen(s,k,idx1-1,idx2,dp),maxLen(s,k,idx1,idx2-1,dp));
        return dp[idx1][idx2] = Math.max(pick,notPick);
    }
}