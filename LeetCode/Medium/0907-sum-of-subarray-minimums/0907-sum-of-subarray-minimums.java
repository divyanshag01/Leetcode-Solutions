class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> nst = new Stack<>();
        Stack<Integer> pst = new Stack<>();
        int nse[] = new int[arr.length];
        int pse[] = new int[arr.length];
        for(int i = arr.length-1;i>=0;i--){
            while(!nst.isEmpty()&&arr[nst.peek()]>arr[i]){
                nst.pop();
            }
            nse[i] = nst.isEmpty()?arr.length:nst.peek();
            nst.push(i);
        }
        for(int i = 0;i<arr.length;i++){
            while(!pst.isEmpty()&&arr[pst.peek()]>=arr[i]){
                pst.pop();
            }
            pse[i] = pst.isEmpty()?-1:pst.peek();
            pst.push(i);
        }
        long total = 0;
        int mod = 1000000007;
        for(int i = 0;i<arr.length;i++){
            long left = i-pse[i];
            long right = nse[i]-i;
            total = (total+ (left*right*1L*arr[i]))%mod;
        }
        return (int)total;


    }
}