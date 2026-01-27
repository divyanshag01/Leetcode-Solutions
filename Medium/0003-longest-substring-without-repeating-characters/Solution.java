class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int max = 0;
        while(r<s.length()){
            char c = s.charAt(r);
            while(map.containsKey(c)){
                map.remove(s.charAt(l));
                l++;
            }
            map.put(c,r);
            max = Math.max(max,r-l+1);
            r++;

            
        }
        return max;
    }
}