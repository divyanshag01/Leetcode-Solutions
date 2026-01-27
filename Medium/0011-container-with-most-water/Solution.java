class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;
        while(l<r){
            int min = Math.min(height[r],height[l]);
            max=Math.max(max,(r-l)*min);
            if(height[l]==min)l++;
            else r--;
        }
        return max;
    }
}