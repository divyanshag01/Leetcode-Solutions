class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 0;
        int max = nums[0];
        for(int num:nums){
            max = Math.max(max,num);
        }
        int ans = max;
        int r = max;
        while(l<=r){
            int mid = l + (r-l)/2;
            int sum = 0;
            for(int num:nums){
                double d =  (double)num/mid;
                sum += Math.ceil(d);
            }
            if(sum<=threshold){
                r = mid-1;
                ans = mid;
            }else{
                l = mid+1;
            }           
        }
        return ans;
    }
}