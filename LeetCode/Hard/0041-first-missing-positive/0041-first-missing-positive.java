class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int n =0;
        for(int i = 1;i<=nums.length;i++){
            if(!set.contains(i)){
                n=i;
                break;
            }
        }
        return n==0?nums.length+1:n;
    }
}