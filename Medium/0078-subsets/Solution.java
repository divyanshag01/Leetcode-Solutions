class Solution {
    public void generate(List<List<Integer>> sub, int temp[],int nums[],int index,int n){
        if(index >= n){
            List<Integer> temp2 = new ArrayList<>();
            for(int i = 0;i<n;i++){
                if(temp[i]!=0){
                    temp2.add(nums[i]);
                }
            }
            sub.add(temp2);
            return;
        }
        temp[index]=0;
        generate(sub,temp,nums,index+1,n);
        temp[index]=1;
        generate(sub,temp,nums,index+1,n);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sub = new ArrayList<>();
        int n = nums.length;
        int temp[] = new int[n];
        generate(sub,temp,nums,0,n);
        return sub;
    }
}