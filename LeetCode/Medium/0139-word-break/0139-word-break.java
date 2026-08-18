class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1); 
        return check(s,wordDict,0,dp);
    }
    public boolean check(String s,List<String> wordDict,int idx,int dp[]){
        if(idx==s.length()) return true;
        if(dp[idx]!=-1)return dp[idx]==1?true:false;
        for(int i = 0;i<wordDict.size();i++){
            String word = wordDict.get(i);
            if(word.length()>s.length()-idx)continue;
            char c = word.charAt(0);
            if(c!=s.charAt(idx)) continue;
            String k = s.substring(idx,idx+word.length());
            if(k.equals(word)){
                if(check(s,wordDict,idx+word.length(),dp)){
                    dp[idx] = 1;
                    return true;
                }else{
                    dp[idx] = 0;
                }
            }
        }
        // for(int i = 0;i<wordDict.size();i++){
        //     dp[idx][i] = false;
        // }
        return false;
    }
}