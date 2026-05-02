class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int cnt = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i :nums){
            if(i%2!=0){
                sum++;
            }
            if(map.containsKey(sum-k)){
                cnt+= map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}