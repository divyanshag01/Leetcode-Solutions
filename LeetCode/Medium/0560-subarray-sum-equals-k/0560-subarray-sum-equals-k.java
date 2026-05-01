class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int cnt =  0;
        int sum = 0;
        for(int i:nums){
            sum+= i;
            if(map.containsKey(sum-k)){
                cnt+=map.get(sum-k);
                // map.put(k-sum,map.get(k-sum)+1);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}