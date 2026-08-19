class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums2.length;
        int ans[] = new int[n];
        for(int i = n-1 ;i>=0;i--){
            int num = nums2[i];
            while(!st.isEmpty() && st.peek()<=num){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }
            st.push(num);
            map.put(num,ans[i]);
        }
        for(int i = 0;i<nums1.length;i++){
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}