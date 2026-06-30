class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return distinct(s,t,n-1,m-1,dp);
    }
    public int distinct(String s,String t,int idx1,int idx2,int dp[][]){
        if(idx2<0) return 1;
        if(idx1<0) return 0;
        int pick = 0;
        int notPick = 0;
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        if(s.charAt(idx1)==t.charAt(idx2)){
            pick = distinct(s,t,idx1-1,idx2-1,dp);
        }
        notPick = distinct(s,t,idx1-1,idx2,dp);
        return dp[idx1][idx2] = pick+notPick;
    }
}