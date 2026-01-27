class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> ps = new HashMap<>();
        ps.put(0,1);
        int sum = 0;
        int sb = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            if(ps.containsKey(sum-k))sb += ps.get(sum-k);
            if(ps.containsKey(sum)) ps.put(sum,ps.get(sum)+1);
            else ps.put(sum,1);
        }
        return sb;
    }
}