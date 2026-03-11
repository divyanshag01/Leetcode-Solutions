class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int curr = 0;
        int cnt = 0;
        int max= 0;
        for(int num:set){
            if(!set.contains(num-1)){
                curr = num;
                cnt = 1;
                while(set.contains(curr+1)){
                    curr++;
                    cnt++;
                }
                max = Math.max(max,cnt);
            }
        }
        return max;
    }
}