class Solution {
    public int find(int nums[],int k){
        int l = 0;
        int r = 0;
        int cnt = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r<nums.length){
            if(map.containsKey(nums[r])){
                map.put(nums[r],map.get(nums[r])+1);
            }else{
                map.put(nums[r],1);
            }
            while(map.size()>k){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
            }
            cnt += r-l+1;
            r++;
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return find(nums,k) - find(nums,k-1);
    }
}