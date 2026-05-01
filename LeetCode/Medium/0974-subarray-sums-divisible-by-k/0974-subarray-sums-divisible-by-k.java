class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int cnt = 0;
        for(int i: nums){
            sum+=i;
            int rem = sum%k;
            rem = rem<0?rem+k:rem;//storing and checking positive remienders
            if(map.containsKey(rem)){
                cnt+= map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return cnt;
    }
}