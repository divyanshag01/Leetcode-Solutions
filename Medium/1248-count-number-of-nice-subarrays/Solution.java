class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int sum = 0;
        int cnt = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0;i<nums.length;i++){
            if(nums[i]%2!=0)sum++;
            if(map.containsKey(sum-k)){
                cnt += map.get(sum-k);
            }
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
            }else{
                map.put(sum,1);
            }
        }
        return cnt;
    }
}