class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int l = 0;
        int r = 0;
        String chr = "";
        while(l<strs[0].length()){
            if(strs[0].charAt(l)!=strs[strs.length-1].charAt(r)){
                break;
            }
            chr+=strs[0].charAt(l);
            l++;
            r++;
        }
        return chr;
    }
}