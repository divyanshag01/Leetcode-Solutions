class Solution {
    public void generate(List<List<Integer>> ans, int nums[],List<Integer> temp,boolean arr[]){
        if(temp.size()==nums.length){
            ans.add(new ArrayList(temp));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(arr[i]) continue;
            arr[i] = true;
            temp.add(nums[i]);
            generate(ans,nums,temp,arr);
            temp.remove(temp.size()-1);
            arr[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean arr[] = new boolean[nums.length];
        generate(ans,nums,temp,arr);
        return ans;
    }
}