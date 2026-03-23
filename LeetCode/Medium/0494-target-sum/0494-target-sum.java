class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        if((target+sum)%2!=0 || target+sum<0)return 0;

        target = (target+sum)/2;
        int dp[][] = new int[nums.length][target+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums.length-1,nums,target,dp);
    }
    public int solve(int idx,int nums[],int target,int dp[][]){
        if(idx==0){
            if(target==0 && nums[idx]==0) return 2;
            if(target==0 || nums[idx]==target) return 1;
            return 0;
        }
        if(dp[idx][target]!=-1)return dp[idx][target];
        int notPick = solve(idx-1,nums,target,dp);
        int pick = 0;
        if(nums[idx]<=target){
            pick =solve(idx-1,nums,target-nums[idx],dp);
        }
        return dp[idx][target]=pick+notPick;
    }
}