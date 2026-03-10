class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int cnt = 0;
        int start = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;
        while(r<n){
            char ch = s.charAt(r);
            if(map.containsKey(ch) && map.get(ch)>0){
                cnt++;
            }
            map.put(ch,map.getOrDefault(ch,0)-1);
            while(cnt==m){
                if(r-l+1<min){
                    min = r-l+1;
                    start = l;
                }
                // min = Math.min(min,r-l+1);
                if(map.get(s.charAt(l))==0){
                    cnt--;
                }
                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)+1);
                l++;
            }
            r++;
        }
        if(start==-1) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = start;i<min+start;i++) sb.append(s.charAt(i));
        return sb.toString();
    }
}