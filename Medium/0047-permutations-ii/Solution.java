class Solution {
    public void generate(List<List<Integer>> ans, int nums[], List<Integer> temp,boolean check[]){
        if(temp.size()==nums.length){
            ans.add(new ArrayList(temp));
        }
        for(int i = 0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1] && !check[i-1]) continue;
            if(check[i]) continue;
            temp.add(nums[i]);
            check[i] = true;
            generate(ans,nums,temp,check);
            temp.remove(temp.size()-1);
            check[i] = false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean check[] = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        generate(ans,nums,temp,check);
        return ans;
    }
}