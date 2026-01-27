class Solution {
    public void reverse(int[] matrix){
        int r = matrix.length-1;
        int l = 0;
        while(l<r){
            int temp = matrix[l];
            matrix[l]=matrix[r];
            matrix[r]=temp;
            l++;
            r--;
        }
    }
    public void rotate(int[][] matrix) {
        for(int i = 0; i< matrix.length;i++){
            for(int j = i+1; j< matrix[0].length;j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        for(int i = 0 ; i< matrix.length; i++){
            reverse(matrix[i]);
        }
    }
}