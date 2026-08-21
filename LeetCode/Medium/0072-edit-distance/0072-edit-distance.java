class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return check(word1,word2,word1.length()-1,word2.length()-1,dp);
        // return word1.length()-common;
    }
    public int check(String word1,String word2,int idx1,int idx2,int dp[][]){
        if(idx1<0) return idx2 + 1;
        if(idx2<0) return idx1 + 1;
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        if(word1.charAt(idx1)==word2.charAt(idx2)){
            return dp[idx1][idx2] = check(word1,word2,idx1-1,idx2-1,dp);
        }
        // int notPick = check(word1,word2,idx1-1,idx2);
        return dp[idx1][idx2] = 1 + Math.min(check(word1,word2,idx1,idx2-1,dp),Math.min(check(word1,word2,idx1-1,idx2-1,dp),check(word1,word2,idx1-1,idx2,dp)));
    }
}