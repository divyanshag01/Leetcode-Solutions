class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return maxLen(text1,text2,text1.length()-1,text2.length()-1,dp);
    }
    public int maxLen(String text1,String text2,int idx1,int idx2,int dp[][]){
        if(idx1 < 0 || idx2<0) return 0;
        int match = 0;
        int notMatch = 0;
        if(dp[idx1][idx2]!=-1)return dp[idx1][idx2];
        if(text1.charAt(idx1)==text2.charAt(idx2)){
            match = 1 + maxLen(text1,text2,idx1-1,idx2-1,dp);
        }else{
            notMatch = Math.max(maxLen(text1,text2,idx1-1,idx2,dp),maxLen(text1,text2,idx1,idx2-1,dp));
        }
        return dp[idx1][idx2] = Math.max(match,notMatch);
    }
}