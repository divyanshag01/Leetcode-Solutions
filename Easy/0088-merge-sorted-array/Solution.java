class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = 0;
        int r = 0;
        int k =0;
        int arr[] = new int[n+m];
        while(l<m && r<n){
            if(nums1[l]<=nums2[r]){
                arr[k] = nums1[l];
                l++;
            }else{
                arr[k]=nums2[r];
                r++;
            }
            k++;
        }
        while(l<m){
            arr[k]=nums1[l];
            l++;
            k++;
        }
        while(r<n){
            arr[k]=nums2[r];
            r++;
            k++;
        }
        for(int i = 0;i<n+m;i++){
            nums1[i]=arr[i];
        }
    }
}