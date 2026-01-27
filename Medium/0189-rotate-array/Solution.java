class Solution {
    public static void reverse(int nums[],int l,int r){
        while(l<r){
            int temp = nums[l];
            nums[l]=nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int l = 0;
        int r = n-1;
        reverse(nums,l,r);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
}