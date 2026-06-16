class Solution {
    public String processStr(String s) {
        StringBuffer sb = new StringBuffer();
        // StringBuffer sb = new StringBuffer();
        // int idx = -1;
        for(char c: s.toCharArray()){
           if(c=='*'){
            if(sb.length()>=1){
                sb.deleteCharAt(sb.length()-1);
            }
            }else if(c=='#'){
                StringBuffer k = new StringBuffer();
                k = sb;
                sb.append(k);
            }else if(c=='%'){
                sb.reverse();
            }else{
                sb.append(c);
            }

        }
        return sb.toString();
    }
}