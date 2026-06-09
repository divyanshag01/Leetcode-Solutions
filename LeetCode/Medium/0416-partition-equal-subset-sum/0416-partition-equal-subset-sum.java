class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        int dp[][] = new int[n][(sum/2)+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return generate(nums,n-1,sum/2,dp);
    }
    public boolean generate(int nums[],int n,int sum,int dp[][]){
        if(sum<0) return false;
        if(n==0){
            if(sum-nums[0]==0) return true;
            else return false;
        }
        if(n<0) return false;
        if(dp[n][sum]!=-1)return dp[n][sum]==1;
        boolean pick = generate(nums,n-1,sum-nums[n],dp);
        boolean notPick = generate(nums,n-1,sum,dp);
        dp[n][sum] = pick||notPick?1:0;
        return pick||notPick;
    }
}