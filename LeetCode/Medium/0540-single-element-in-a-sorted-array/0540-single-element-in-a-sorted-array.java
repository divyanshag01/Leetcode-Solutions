class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1)return nums[0];
        int l = 1;
        int r = nums.length-2;
        if(nums[0]!=nums[1])return nums[0];
        if(nums[r]!=nums[r+1])return nums[r+1];
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid-1]!=nums[mid] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            if(mid%2==0){
                if(nums[mid]==nums[mid-1]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }
            if(mid%2!=0){
                if(nums[mid]==nums[mid-1]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}