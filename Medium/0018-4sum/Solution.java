class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i  = 0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            for(int j = i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1])continue;
                int l = j+1;
                int r = n-1;
                while(l<r){
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum==target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        int a = nums[l];
                        int b = nums[r];
                        while(nums[l]==a && l<r)l++;
                        while(nums[r]==b && r>l)r--;
                        // l++;
                        // r--;
                    }else if(sum<target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}