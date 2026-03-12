class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> nst = new Stack<>();
        Stack<Integer> pst = new Stack<>();
        Stack<Integer> ngt = new Stack<>();
        Stack<Integer> pgt = new Stack<>();
        int n = nums.length;
        int nstArr[] = new int[n];
        int pstArr[] = new int[n];
        int ngtArr[] = new int[n];
        int pgtArr[] = new int[n];
        for(int i = n-1;i>=0;i--){
            while(!nst.isEmpty() && nums[nst.peek()]>nums[i]){
                nst.pop();
            }
            nstArr[i] = nst.isEmpty()?n:nst.peek();
            nst.push(i);
        }
        for(int i = n-1;i>=0;i--){
            while(!ngt.isEmpty() && nums[ngt.peek()]<nums[i]){
                ngt.pop();
            }
            ngtArr[i] = ngt.isEmpty()?n:ngt.peek();
            ngt.push(i);
        }
        for(int i = 0;i<n;i++){
            while(!pst.isEmpty() && nums[pst.peek()]>=nums[i]){
                pst.pop();
            }
            pstArr[i] = pst.isEmpty()?-1:pst.peek();
            pst.push(i);
        }
        for(int i = 0;i<n;i++){
            while(!pgt.isEmpty() && nums[pgt.peek()]<=nums[i]){
                pgt.pop();
            }
            pgtArr[i] = pgt.isEmpty()?-1:pgt.peek();
            pgt.push(i);
        }
        long minTotal = 0;
        long maxTotal = 0;
        for(int i = 0;i<nums.length;i++){
            long left = i-pstArr[i];
            long right = nstArr[i]-i;
            minTotal = minTotal +(left*right*1L*nums[i]);
        }
        for(int i = 0;i<nums.length;i++){
            long left = i-pgtArr[i];
            long right = ngtArr[i]-i;
            maxTotal = maxTotal +(left*right*1L*nums[i]);
        }
        return maxTotal-minTotal;
    }
}