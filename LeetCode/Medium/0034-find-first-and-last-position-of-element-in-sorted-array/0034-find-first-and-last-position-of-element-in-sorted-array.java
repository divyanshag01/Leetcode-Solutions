class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]>=target){
                if(target==nums[mid]) first = mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        l = 0;
        r = nums.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]==target){
                last = mid;
                l=mid+1;
            }else if (target<nums[mid]){
                r=mid-1;
            }else{
                l = mid+1;
            }
        }
        return new int[] {first,last};
    }
}