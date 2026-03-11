class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int arr[] = new int[nums2.length];
        for(int i = nums2.length-1;i>=0;i--){
            int e = -1;
            while(!st.isEmpty()){
                if(st.peek()>nums2[i]){
                    e = st.peek();
                    break;
                }else{
                    st.pop();
                }
            }
            st.push(nums2[i]);
            arr[i]=e;
            map.put(nums2[i],e);
        }
        for(int i = 0;i<nums1.length;i++){
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
         
    }
}