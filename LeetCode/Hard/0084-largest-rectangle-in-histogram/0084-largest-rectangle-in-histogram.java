class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> nst = new Stack<>(); 
        Stack<Integer> pst = new Stack<>();
        int n = heights.length;
        int nArr[] = new int[n]; 
        int pArr[] = new int[n];
        for(int i = n-1;i>=0;i--){
            while(!nst.isEmpty() && heights[nst.peek()]>=heights[i]){
                nst.pop();
            }
            nArr[i] = nst.isEmpty()?n:nst.peek();
            nst.push(i);
        } 
        for(int i = 0;i<n;i++){
            while(!pst.isEmpty() && heights[pst.peek()]>=heights[i]){
                pst.pop();
            }
            pArr[i] = pst.isEmpty()?-1:pst.peek();
            pst.push(i);
        }
        int max = 0;
        for(int i = 0;i<n;i++){
            max = Math.max(max,(nArr[i]-pArr[i]-1)*heights[i]);
        }
        return max;
    }
}