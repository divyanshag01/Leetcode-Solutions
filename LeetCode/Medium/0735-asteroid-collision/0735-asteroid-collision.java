class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<asteroids.length;i++){
            if(!st.isEmpty() && asteroids[i]<0 && st.peek()>0){
                while(!st.isEmpty()&&st.peek()>0&&st.peek()<(-asteroids[i])){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()>Math.abs(asteroids[i])){
                    continue;
                }
                if(!st.isEmpty() && st.peek()==Math.abs(asteroids[i])){
                    st.pop();
                    continue;
                }
            }
                st.push(asteroids[i]);
        }
        int arr[] = new int[st.size()];
        ArrayList<Integer> list = new ArrayList<>();
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        Collections.reverse(list);
        int i = 0;
        for(int nums:list){
            arr[i++]=nums;
        }
        return arr;
    }
}