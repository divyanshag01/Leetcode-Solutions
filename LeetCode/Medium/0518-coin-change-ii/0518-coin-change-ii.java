class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(coins.length-1,amount,coins,dp);
    }
    public int solve(int idx,int amount,int coins[],int dp[][]){
        // if(amount==0)return 1;
        if(idx==0){
            if(amount == 0) return 1;
            if(coins[idx]<=amount && amount%coins[idx]==0) return 1;
            return 0;
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int notPick = solve(idx-1,amount,coins,dp);
        int pick = 0;
        if(coins[idx]<=amount){
            pick = solve(idx,amount-coins[idx],coins,dp);
        }
        return dp[idx][amount]=pick+notPick;
    }
}