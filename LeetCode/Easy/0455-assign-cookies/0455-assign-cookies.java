class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int max= 0;
        int l = 0;
        int r = 0;
        while(l<g.length && r<s.length){
            if(g[l]<=s[r]){
                l++;
                r++;
                max++;
            }else{
            r++;}
        }
        return max;
    }
}