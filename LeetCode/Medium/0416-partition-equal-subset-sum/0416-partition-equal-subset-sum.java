class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums) sum+=num;
        if(sum%2!=0) return false;
        int dp[][] = new int[nums.length][sum/2 +1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums.length-1,sum/2,nums,dp);
    }
    public boolean solve(int idx,int sum,int nums[],int dp[][]){
        if(sum==0){
            return true;
        }
        if(idx<0){
            return false;
        }
        if(dp[idx][sum]!=-1) return dp[idx][sum]==1;
        boolean notTake = false;
        boolean take = false;
        if(nums[idx]<=sum){
            take = solve(idx-1,sum-nums[idx],nums,dp);
        }
        notTake = solve(idx-1,sum,nums,dp);
        boolean ans = take||notTake;
        dp[idx][sum] = ans?1:0;
        return ans;
    }
}