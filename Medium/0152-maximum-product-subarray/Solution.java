class Solution {
    public int maxProduct(int[] nums) {
        int max  = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            int temp = nums[i];
            int product = nums[i];
            for(int j = i+1;j<nums.length;j++){
                product*=nums[j];
                temp = Math.max(temp,product);
            }
            max=Math.max(max,temp);
        }
        return max;
    }
}