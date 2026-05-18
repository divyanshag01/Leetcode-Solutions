class Solution {
    public int findPeakElement(int[] nums) {
        int l = 1;
        int r = nums.length-2;
        if(nums.length==1)return 0;
        if(nums[l]<nums[0]) return 0;
        if(nums[r]<nums[r+1]) return r+1;
        while(l<=r){
            int mid = l +(r-l)/2;
            if(nums[mid-1]<nums[mid] && nums[mid+1]<nums[mid]){
                return mid;
            }else if(nums[mid]>nums[mid-1]){
                l= mid+1;
            }else{
                r=mid-1;
            }
        }   
        return -1;
    }
}