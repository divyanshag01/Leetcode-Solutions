class Solution {
    public int longestOnes(int[] nums, int k) {
        int one = 0;
        int zero = 0;
        int l =0;
        int r = 0;
        int max = 0;
        while(r<nums.length){
            //counting one is uneccesary 
           if(nums[r]==1)one++;
           else zero++;
           while(zero>k){
            if(nums[l]==1)one--;
            else zero--;
            l++;
           }
           max = Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}