class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> star = new Stack<>();
        // int cnt = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                st.push(i);
            }
            else if(c=='*')star.push(i);
            if(c==')'){
                if(st.isEmpty() && star.isEmpty()){
                    return false;
                }else if(!st.isEmpty()){
                    st.pop();
                }else{
                    star.pop();
                }

            }
        }
        while(!st.isEmpty() && !star.isEmpty()){
            if(st.peek()<star.peek()){
                st.pop();
                star.pop();
            }else{
                return false;
            }
        }
        return st.isEmpty();
    }
}