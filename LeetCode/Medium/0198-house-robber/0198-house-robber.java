class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return check(nums,dp,n-1);
    }
    public int check(int[] nums,int[] dp,int n){
        if(n==0){
            return nums[0];
        }
        if(n<0) return 0;
        if(dp[n]!=-1)return dp[n];
        int pick = nums[n] + check(nums,dp,n-2);
        int notPick = check(nums,dp,n-1);
        return dp[n] = Math.max(pick,notPick);
    }
}