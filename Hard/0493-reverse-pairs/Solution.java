class Solution {
    public int mergesort(int[] nums, int low,int high){
        int cnt = 0;
        if(low>=high){
            return 0;
        }
        int mid = (low+high)/2;
        cnt +=mergesort(nums,low,mid);
        cnt+=mergesort(nums,mid+1,high);
        cnt+=sort(nums,low,mid,high);
        return cnt;
    }
    public int sort(int[] nums ,int low,int mid, int high){
        int l = low;
        int r = mid+1;
        int[] temp = new int[high-low+1];
        int cnt  = 0;
        int k = 0;
        int j = mid+1;
        for(int i = l;i<=mid;i++){
            while(j<=high && (long)nums[i]>2L*nums[j]){
                cnt+=mid-i+1;
                j++;
            }
        }
        while(l<=mid && r<=high){
            if(nums[l]<=nums[r]){
                temp[k++]=nums[l++];
            }else{
                temp[k++]=nums[r++];
            }
        }
        while(l<=mid){
            temp[k++]=nums[l++];
        }
        while(r<=high){
            temp[k++]=nums[r++];
        }
        for(int i = low;i<=high;i++){
            nums[i]=temp[i-low];
        }
        return cnt;

    } 
    public int reversePairs(int[] nums) {
       int cnt =  mergesort(nums,0,nums.length-1);
       return cnt;
    }
}