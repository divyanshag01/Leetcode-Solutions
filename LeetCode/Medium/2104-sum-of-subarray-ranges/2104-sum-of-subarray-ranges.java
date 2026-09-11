class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> nsi = new Stack<>();
        Stack<Integer> ngi = new Stack<>();
        Stack<Integer> psi = new Stack<>();
        Stack<Integer> pgi = new Stack<>();
        int n = nums.length;
        int nsiArr[] = new int[n];
        int ngiArr[] = new int[n];
        int psiArr[] = new int[n];
        int pgiArr[] = new int[n];
        for(int i = n-1;i>=0;i--){
            while(!nsi.isEmpty() && nums[nsi.peek()]>=nums[i]){
                nsi.pop();
            }
            nsiArr[i] = nsi.isEmpty()?n:nsi.peek();
            nsi.push(i);
        }
        for(int i = n-1;i>=0;i--){
            while(!ngi.isEmpty() && nums[ngi.peek()]<=nums[i]){
                ngi.pop();
            }
            ngiArr[i] = ngi.isEmpty()?n:ngi.peek();
            ngi.push(i);
        }
        for(int i = 0;i<n;i++){
            while(!pgi.isEmpty() && nums[pgi.peek()]<nums[i]){
                pgi.pop();
            }
            pgiArr[i] = pgi.isEmpty()?-1:pgi.peek();
            pgi.push(i);
        }
        for(int i = 0;i<n;i++){
            while(!psi.isEmpty() && nums[psi.peek()]>nums[i]){
                psi.pop();
            }
            psiArr[i] = psi.isEmpty()?-1:psi.peek();
            psi.push(i);
        }
        long total = 0;
        for(int i = 0;i<n;i++){
            long min = (long)(i - psiArr[i]) * (long)(nsiArr[i]-i) * nums[i];
            long max = (long)(i - pgiArr[i]) * (long)(ngiArr[i]-i) * nums[i];
            total = total + (max-min);
        }
        return total;
    }
}