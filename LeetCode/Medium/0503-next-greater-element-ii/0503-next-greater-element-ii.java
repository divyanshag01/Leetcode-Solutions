class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int arr[] = new int[2*n];
        for(int i = 2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
            }
            arr[i]=st.isEmpty()?-1:st.peek();
            st.push(nums[i%n]);
        }
        for(int i=0;i<n;i++){
            nums[i]=arr[i];
        }
        return nums;
    }
}