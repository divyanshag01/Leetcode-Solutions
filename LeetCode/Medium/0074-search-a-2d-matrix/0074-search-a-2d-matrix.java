class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0;
        int r = n-1;
        int ans = 0;
        while(l<=r){
            int mid = l +(r-l)/2;
            if(target>=matrix[mid][0] && target<=matrix[mid][m-1]){
                ans = mid;
                break;
            }else if(target<matrix[mid][0]){
                r= mid-1;
            }else{
                l = mid+1;
            }
        }
        l=0;
        r = m-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(target==matrix[ans][mid]){
                return true;
            }else if(target>matrix[ans][mid]){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return false;
    }
}