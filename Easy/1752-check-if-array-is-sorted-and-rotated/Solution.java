class Solution {
    public boolean check(int[] nums) {
        int down = 0;
        for(int i = 1;i<nums.length+1;i++){
            if(i==nums.length){
                if(nums[0]<nums[i-1]){
                down +=1;
            }}else{
            if(nums[i-1]>nums[i]){
                down +=1;
            }
            }
            if(down>1){
                return false;
            }
        
    }
        return true;
}}