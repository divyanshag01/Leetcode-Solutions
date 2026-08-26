class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length+1];
        for(int row[]:dp){
        Arrays.fill(row,-1); 
        }
        return maxLen(nums,0,-1,dp);
    }
    public int maxLen(int nums[],int idx,int picked,int dp[][]){
        if(idx>=nums.length) return 0;
        if(dp[idx][picked+1]!=-1)return dp[idx][picked+1];

        if(picked==-1){
            int pick = 1 + maxLen(nums,idx+1,idx,dp);
            int notPick = maxLen(nums,idx+1,picked,dp);
            return dp[idx][picked+1] = Math.max(pick,notPick);
        }else{
            int take = 0;
            if(nums[idx]>nums[picked]){
                take = 1 + maxLen(nums,idx+1,idx,dp);
            }
            int notTake = maxLen(nums,idx+1,picked,dp);
            return dp[idx][picked+1] = Math.max(take,notTake);
        }
    }
}