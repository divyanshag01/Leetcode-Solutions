class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            // int sum = nums[i]
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    out.add(new ArrayList<>());
                    out.get(out.size()-1).add(nums[i]);
                    out.get(out.size()-1).add(nums[j]);
                    out.get(out.size()-1).add(nums[k]);
                    while(j<k && nums[j]==nums[j+1])j++;
                    while(k>j && nums[k]==nums[k-1])k--;
                    j++;
                    k--;
                }
                else if(nums[i]+nums[j]+nums[k]<0) j++;
                else k--;
            }
            // while(i<n-1 && nums[i]==nums[i+1])i++;
        }
        return out;
    }
}