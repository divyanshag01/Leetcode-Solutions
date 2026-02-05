class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        for(int i =0;i<n;i++){
            if(nums[i]==0){
                result[i] = nums[i];
            }else if(nums[i]>0){
                int k = nums[i];
                result[i] = nums[(i+k)%n];
            }else{
                int j = Math.abs(nums[i]);
                j = j%n;
                if(i-j<n && i-j>=0){
                    result[i] = nums[i-j];
                }else{
                    result[i] = nums[(n+i-j)%n];
                }
            }
        }
            return result;
    }
}