class Solution {
    public int searchInsert(int[] nums, int target) {
        int ans = nums.length;
        int l = 0;
        int r = nums.length-1;
        // if(target<nums[0])return 0;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(target<=nums[mid]){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
                // ans = l;
            }
        }
        return ans;
    }
}