class Solution {
    public char processStr(String s, long k) {
        StringBuilder sb = new StringBuilder();
        // StringBuilder sb = new StringBuilder();
        // int idx = -1;
        long l = 0;
        for(char c: s.toCharArray()){
           if(c=='*'){
                if(l>0) l--;
            }else if(c=='#'){
                l*=2;
            }else if(c=='%'){
                continue;
            }else{
                l++;
            }

        }
        if(l<=k)return '.';
        for(int i = s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(c=='#'){
                l = l/2;
                if(k>=l){
                    k=k-l;
                }
            }else if(c=='*'){
                l++;
            }else if(c=='%'){
                k = l-k-1;
            }else{
                l--;
            }
            if(k==l){
                return s.charAt(i);
            }
        }
        return '.';
    }
}