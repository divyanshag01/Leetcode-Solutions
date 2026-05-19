class Solution {
    public int splitArray(int[] nums, int k) {
        int l = nums[0];
        int r = 0;
        for(int num:nums){
            l = Math.max(num,l);
            r+=num;
        }
        int ans = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(check(nums,k,mid)){
                r=mid-1;
                ans = mid;
            }else l = mid+1;
        }
        return ans;
    }
    public boolean check(int[] nums,int k,int mid){
        int sum = 0;
        int st = 1;
        for(int num:nums){
            if(num>mid)return false;
            if(num+sum>mid){
                sum = 0;
                st++;
            }
            sum+=num;
        }
        return st<=k;
    }
}