class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        if(k==num.length() || k>num.length()) return "0";
        for(char ch:num.toCharArray()){
            while(!st.isEmpty() && (st.peek()-'0')>(ch-'0')&&k>0){
                st.pop();
                k--;
            }
            st.push((ch));
        }
        while(!st.isEmpty() && k-->0){
            st.pop();
        }
        // int i = 0;
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
            
        }
        return sb.toString();
    }
}