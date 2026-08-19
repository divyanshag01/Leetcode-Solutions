class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return maxMoney(nums,0,dp);
    }
    public int maxMoney(int nums[],int idx,int dp[]){
        if(idx>=nums.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int pick = nums[idx] + maxMoney(nums,idx+2,dp);
        int notPick = maxMoney(nums,idx+1,dp);
        return dp[idx] = Math.max(pick,notPick);
    }
}