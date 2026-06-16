class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        // StringBuilder sb = new StringBuilder();
        // int idx = -1;
        for(char c: s.toCharArray()){
           if(c=='*'){
            if(sb.length()>=1){
                sb.deleteCharAt(sb.length()-1);
            }
            }else if(c=='#'){
                sb.append(sb);
            }else if(c=='%'){
                sb.reverse();
            }else{
                sb.append(c);
            }

        }
        return sb.toString();
    }
}