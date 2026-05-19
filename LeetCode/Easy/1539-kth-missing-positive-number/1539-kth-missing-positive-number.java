class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            int miss = arr[mid]-( mid+1);
            if(miss<k){
                l= mid+1;
            }else{
                r = mid-1;
            }
        }
        // System.out.print(l+" "+r);
        // if(arr[arr.length-1]-arr.length ==0)return arr.length+k;
        return  k+r+1;
    }
}