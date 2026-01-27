class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int arr[] = new int[26];
        // int length = 0;
        int maxfreq = 0;
        int max = 0;
        while(r<s.length()){
            arr[s.charAt(r)-'A']=arr[s.charAt(r)-'A']+1;
            maxfreq= Math.max(maxfreq,arr[s.charAt(r)-'A']);
            while(r-l+1-maxfreq>k){
                arr[s.charAt(l)-'A']=arr[s.charAt(l)-'A']-1;
                l++;
            }
            max = Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}