class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][3];
        for(int row[][]:dp){
            for(int arr[]:row){
            Arrays.fill(arr,-1);
            }
        }
        return max(prices,0,1,2,dp);
    }
    public int max(int prices[],int idx,int state,int cap,int dp[][][]){
        if(idx==prices.length) return 0;
        if(cap==0)return 0;
        if(dp[idx][state][cap]!=-1)return dp[idx][state][cap];
        if(state==1){
            int buy = -prices[idx] + max(prices,idx+1,0,cap,dp);
            int notBuy = max(prices,idx+1,1,cap,dp);
            return dp[idx][state][cap] = Math.max(buy,notBuy);
        }else{
            int sell = prices[idx] +  max(prices,idx+1,1,cap-1,dp);
            int notSell =  max(prices,idx+1,0,cap,dp);
            return dp[idx][state][cap] = Math.max(sell,notSell);
        }
    }
}