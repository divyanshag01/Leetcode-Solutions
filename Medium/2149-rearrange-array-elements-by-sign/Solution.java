class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos = 0;
        int negpos = 1;
        int ans[] = new int[nums.length];
        for(int i = 0; i<nums.length;i++){
            if(nums[i]>=0){
                ans[pos]=nums[i];
                pos+=2;
            }else{
                ans[negpos] =nums[i];
                negpos += 2; 
            }
        }
        return ans;
    }
}