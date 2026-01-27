class Solution {
    public void generate(List<List<Integer>> ans,int nums[], int index,int sum,int target,List<Integer>     temp){
        if(sum==target){
            ans.add(new ArrayList(temp));
            return;
        } 
        if(index==nums.length || sum>target){
           return;
        }
        temp.add(nums[index]);
        generate(ans,nums,index,sum+nums[index],target,temp);
        temp.remove(temp.size()-1);
        generate(ans,nums,index+1,sum,target,temp);
    
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        generate(ans,candidates,0,0,target,temp);
        return ans;
    }
}