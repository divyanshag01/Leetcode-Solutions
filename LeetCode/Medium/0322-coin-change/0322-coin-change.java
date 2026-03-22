class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int coin = solve(coins.length-1,amount,coins,dp);
        return coin==(int)1e9?-1:coin;
    }
    public int solve(int idx,int amount,int coins[],int dp[][]){
        if(amount==0)return 0;
        if(idx==0){
            if(amount%coins[idx]==0) return amount/coins[idx];
            else return (int)1e9;
        }
        if(dp[idx][amount]!=-1)return dp[idx][amount];
        int notPick=solve(idx-1,amount,coins,dp);
        int pick = Integer.MAX_VALUE;
        if(coins[idx]<=amount){
            pick = 1+ solve(idx,amount-coins[idx],coins,dp);
        }
        return dp[idx][amount]=Math.min(notPick,pick);
    }
}