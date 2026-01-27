class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l = k-1;
        int r = cardPoints.length-1;
        // int cmb = k+1;
        int sum = 0;
        for(int i = 0;i<k;i++){
            sum+= cardPoints[i];
        }
        int max = sum;
        while(l>=0){
            sum-= cardPoints[l];
            sum+=cardPoints[r];
            max = Math.max(max,sum);
            l--;
            r--;
        }
        return max;
    }
}