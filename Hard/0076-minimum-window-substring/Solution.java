class Solution {
    public String minWindow(String s, String t) {
        int l = 0;
        int r = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int n = t.length();
        for(int i = 0;i<n;i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))+1);
            }else{
                map.put(t.charAt(i),1);
            }
        }
        int cnt = 0;
        int minlen = Integer.MAX_VALUE;
        int start = -1;
        while(r<s.length()){
            char ch = s.charAt(r);
            if(map.containsKey(ch) && map.get(ch)>0){
                cnt++;
            }
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
            }else{
                map.put(ch,-1);
            }
            while(cnt==n){
                char c = s.charAt(l);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                }else{
                    map.put(c,+1);
                }
                // minlen=Math.min(minlen,r-l+1);
                // start = ;
                if(r-l+1<minlen){
                    minlen = r-l+1;
                    start = l;
                }
                if(map.containsKey(c) && map.get(c)>0){
                    cnt--;
                }
                l++;
            }
            r++;
        }
        String ans  = "";
        if(start>-1){for(int i = start;i<minlen+start;i++){
            ans+=s.charAt(i);
        }}
        return ans;
    }
}