class Solution {
    public void generate(List<List<Integer>> ans,int arr[],int index,int k,int n,List<Integer>temp){
        if(temp.size()==k && n==0){
            ans.add(new ArrayList(temp));
            return;
        }
        if(temp.size()==k || index==arr.length){
            return;
        }
        temp.add(arr[index]);
        generate(ans,arr,index+1,k,n-arr[index],temp);
        temp.remove(temp.size()-1);
        generate(ans,arr,index+1,k,n,temp);

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[]={1,2,3,4,5,6,7,8,9};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        generate(ans,arr,0,k,n,temp);
        return ans;
    }
}