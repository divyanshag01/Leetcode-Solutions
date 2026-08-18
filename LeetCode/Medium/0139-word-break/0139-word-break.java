class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[][] = new int[s.length()][wordDict.size()];
        for(int row[]:dp) Arrays.fill(row,-1); 
        return check(s,wordDict,0,dp);
    }
    public boolean check(String s,List<String> wordDict,int idx,int dp[][]){
        if(idx==s.length()) return true;
        for(int i = 0;i<wordDict.size();i++){
            if(dp[idx][i]!=-1)return dp[idx][i]==1?true:false;
            String word = wordDict.get(i);
            if(word.length()>s.length()-idx)continue;
            char c = word.charAt(0);
            if(c!=s.charAt(idx)) continue;
            String k = s.substring(idx,idx+word.length());
            if(k.equals(word)){
                if(check(s,wordDict,idx+word.length(),dp)){
                    dp[idx][i] = 1;
                    return true;
                }else{
                    dp[idx][i] = 0;
                }
            }
        }
        // for(int i = 0;i<wordDict.size();i++){
        //     dp[idx][i] = false;
        // }
        return false;
    }
}