class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1;i<nums.length;i++){
            if(list.get(list.size()-1)<nums[i]){
                list.add(nums[i]);
            }else{
                int idx = lowerBound(nums[i],list);
                list.set(idx,nums[i]);
            }
        }
        return list.size();
    }
    public int lowerBound(int target,ArrayList<Integer> list){
        int l = 0;
        int r = list.size()-1;
        int ans = r;
        while(l<=r){
            int mid = l+ (r-l)/2;
            if(list.get(mid)<target){
                l = mid+1;
            }else{
                ans = mid;
                r = mid-1;
            }
        }
        return ans;
    }
}