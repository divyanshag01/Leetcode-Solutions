class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        int cnt = 1;
        for(int i = nums.length-1;i>=0;i--){
            if(nums[i]<max){
                max=nums[i];
                cnt++;
            }
            if(cnt==3)break;
            
        }
        if(cnt==3)return max;
        else{
            return nums[nums.length-1];
        }
    }
}