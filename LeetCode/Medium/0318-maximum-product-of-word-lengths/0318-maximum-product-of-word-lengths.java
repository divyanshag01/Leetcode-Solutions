class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        int mask[] = new int[words.length];
        for(int i = 0;i<words.length;i++){
            int mask1 = 0;
            for(char c:words[i].toCharArray()){
                mask1 = mask1 | (1<<(c-'a'));
            }
            mask[i] = mask1;
        }
        for(int i = 0;i<words.length;i++){
            int mask1 = mask[i];
            for(int j = i+1;j<words.length;j++){
                int mask2 = mask[j];
                if((mask1&mask2)==0){
                    max = Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
}