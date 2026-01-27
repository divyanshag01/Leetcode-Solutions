class Solution {
    public static void merge(int nums[],int l,int r){
        if(l>=r){
            return;
        }
        int mid = l + (r-l)/2;
        merge(nums,l,mid);
        merge(nums,mid+1,r);
        sort(nums,l,mid,r);
    }
    public static void sort(int nums[], int l, int mid,int r){
        int left = l;
        int right = mid+1;
        int temp[] = new int[r-l+1];
        int i = 0;
        while(left<mid+1 && right <r+1){
            if(nums[left]<nums[right]){
                temp[i] = nums[left];
                left++;
            }else{
                temp[i] = nums[right];
                right++;
            }
            i++;
        }
        while(left<mid+1){
            temp[i] = nums[left];
            i++;
            left++;
        }
        while(right<r+1){
            temp[i] = nums[right];
            i++;
            right++;
        }
        for(int j = 0;j<temp.length;j++){
            nums[l+j] = temp[j];
        }

    }
    public int[] sortArray(int[] nums) {
        merge(nums,0,nums.length-1);
        return nums;
    }
}