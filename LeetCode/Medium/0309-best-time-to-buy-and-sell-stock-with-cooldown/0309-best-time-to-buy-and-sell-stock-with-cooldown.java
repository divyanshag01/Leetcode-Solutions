class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length+2][2];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        int n = prices.length;
        for(int i = n-1;i>=0;i--){
            dp[i][1] = Math.max(-prices[i] + dp[i+1][0],dp[i+1][1]);
            dp[i][0] = Math.max(prices[i] + dp[i+2][1],dp[i+1][0]);

        }
        // return find(prices,0,1,dp);
        return dp[0][1];
    
    // public int find(int prices[],int idx,int state,int dp[][]){
    //     if(idx>=prices.length) return 0;
    //     if(dp[idx][state]!=-1) return dp[idx][state];
    //     if(state==1){
    //         int buy = -prices[idx] + find(prices,idx+1,0,dp);
    //         int notBuy = find(prices,idx+1,1,dp);
    //         return dp[idx][state] = Math.max(buy,notBuy);
    //     }else{
    //         int sell = prices[idx] + find(prices,idx+2,1,dp);
    //         int notSell = find(prices,idx+1,0,dp);
    //         return dp[idx][state] = Math.max(sell,notSell);
    //     }
    }
}