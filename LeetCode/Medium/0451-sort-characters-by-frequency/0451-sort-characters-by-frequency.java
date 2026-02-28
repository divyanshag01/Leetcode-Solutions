class Solution {
    public String frequencySort(String s) {
        int freq[] = new int[128];
        Integer idx[] = new Integer[128];
        for(int i = 0;i<s.length();i++){
            freq[s.charAt(i)-'0']++;
        }
        for(int i = 0;i<128;i++)idx[i] = i;
        Arrays.sort(idx,(i,j) -> Integer.compare(freq[j],freq[i]));
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<128;i++){
            while(freq[idx[i]]-->0){
                sb.append((char)(idx[i]+'0'));
            }
        }
        return sb.toString();
    }
}