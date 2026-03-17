class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int temp1[] = new int[nums.length-1];
        int temp2[] = new int[nums.length-1];

        for(int i = 0;i<n-1;i++){
            temp1[i] = nums[i];
        }
        for(int i = 1;i<n;i++){
            temp2[i-1] = nums[i];
        }

       return Math.max(sol(temp1),sol(temp2));
    }
    public int sol(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return maxSum(nums,nums.length-1,dp);
    }
    public int maxSum(int[] nums, int n, int dp[]) {
        if (n < 0)
            return 0;
        if (n == 0)
            return nums[0];
        if (dp[n] != -1)
            return dp[n];
        int pick = nums[n] + maxSum(nums, n - 2, dp);
        int notPick = maxSum(nums, n - 1, dp);
        return dp[n] = Math.max(pick, notPick);
    }
}