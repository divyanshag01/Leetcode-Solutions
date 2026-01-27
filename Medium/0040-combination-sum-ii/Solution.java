class Solution {
    public void generate(List<List<Integer>> ans,int nums[],int index,int target,List<Integer> temp)    {
            if(target==0){
                ans.add(new ArrayList(temp));
                return;
            }
            // if(index==nums.length){
            //     return;
            // }
            // while(index<nums.length-1 && nums[index]==nums[index+1]){
            //     index++;
            // }
            for(int i = index;i<nums.length;i++){
                if(i>index && nums[i]==nums[i-1]){
                    continue;
                }
                if(nums[i]>target){
                    break;
                }
                temp.add(nums[i]);
                generate(ans,nums,i+1,target-nums[i],temp);
                temp.remove(temp.size()-1);
            }
        }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        generate(ans,candidates,0,target,temp);
        return ans;
    }
}