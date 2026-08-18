class Solution {
    public int coinChange(int[] coins, int amount) {
        // Arrays.sort(coins);
        int dp[][] = new int[amount+1][coins.length];
        for(int row[]:dp){
        Arrays.fill(row,-1);
        }
        int coin = check(coins,amount,coins.length-1,dp);
        if(coin>=Integer.MAX_VALUE-10000) return -1;
        return coin;
    }
    public int check(int coins[],int amount,int idx,int dp[][]){
        if(amount == 0) return 0;
        if(idx<0) return Integer.MAX_VALUE-10000;
        if(!(amount>Integer.MAX_VALUE-10001) && dp[amount][idx]!=-1) return dp[amount][idx];
        int pick = Integer.MAX_VALUE-10000;
        int notPick = Integer.MAX_VALUE-10000;
        if(amount>=coins[idx]){
            // int num = amount/coins[idx];
            pick=1+check(coins,amount-coins[idx],idx,dp);
        }
        notPick=check(coins,amount,idx-1,dp);
        return dp[amount][idx] = Math.min(pick,notPick);
    }
}