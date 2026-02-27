class Solution {
    public boolean isAnagram(String s, String t) {
        //can be done via sorting,hashmap,freq array
        int freq[] = new int[26];
        //int freqt = new int[26];
        for(int i = 0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;

        }
        for(int i = 0;i<26;i++){
            if(freq[i]!=0)return false;
        }
        return true;
    }
}