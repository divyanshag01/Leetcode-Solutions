class Solution {
    public void generate(List<List<Integer>> ans,int nums[],int index,List<Integer> temp){
        ans.add(new ArrayList(temp));
        
        for(int i = index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            generate(ans,nums,i+1,temp);
            temp.remove(temp.size()-1);
        }
        // generate(ans,nums,index+1,temp);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        generate(ans,nums,0,temp);
        return ans;
    }
}