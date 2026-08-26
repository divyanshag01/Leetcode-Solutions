class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for(int i = n-1;i>=0;i--){
            for(int j = -1;j<i;j++){
                int pick = 0;
                int notPick = dp[i+1][j+1];
                if(j==-1 || nums[i]>nums[j]){
                    pick = 1 + dp[i+1][i+1];
                }
                dp[i][j+1] = Math.max(pick,notPick);

            }
        }
        // for(int row[]:dp){
        //     Arrays.fill(row,-1); 
        // }
        return dp[0][0];
    }
    // public int maxLen(int nums[],int idx,int picked,int dp[][]){
    //     if(idx>=nums.length) return 0;
    //     if(dp[idx][picked+1]!=-1)return dp[idx][picked+1];

    //     if(picked==-1){
    //         int pick = 1 + maxLen(nums,idx+1,idx,dp);
    //         int notPick = maxLen(nums,idx+1,picked,dp);
    //         return dp[idx][picked+1] = Math.max(pick,notPick);
    //     }else{
    //         int take = 0;
    //         if(nums[idx]>nums[picked]){
    //             take = 1 + maxLen(nums,idx+1,idx,dp);
    //         }
    //         int notTake = maxLen(nums,idx+1,picked,dp);
    //         return dp[idx][picked+1] = Math.max(take,notTake);
    //     }
    // }
}