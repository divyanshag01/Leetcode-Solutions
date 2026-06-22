class Solution {
    public int maxNumberOfBalloons(String text) {
        int freq[] = new int[26];
        int max = 0;
        for(char c:text.toCharArray()){
            freq[c-'a']++;
            max = Math.max(freq[c-'a'],max);
        }
        String s = "balloon";
        int cnt = max;
        for(char c:s.toCharArray()){
            int n = freq[c-'a'];
            if(c=='l' || c=='o'){
                n = n/2;
            }
            cnt = Math.min(n,cnt);
        }
        return cnt;
    }
}