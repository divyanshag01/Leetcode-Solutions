class Solution {
    public int numberOfSubstrings(String s) {
        int cnt = 0;
        int l = 0;
        int r = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(r<s.length()){
            char c = s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.size()==3) cnt = cnt+(s.length()-(r+1));
            while(map.size()==3){
                cnt++;
                char t = s.charAt(l);
                map.put(t,map.getOrDefault(t,0)-1);
                if(map.get(t)==0) map.remove(t);
                if(map.size()==3) cnt = cnt+(s.length()-(r+1));
                l++;
            }
            r++;
        }
        return cnt;   
    }
}