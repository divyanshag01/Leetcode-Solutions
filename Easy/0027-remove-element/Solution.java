class Solution {
    public int removeElement(int[] nums, int val) {
        int pos = 0;
        int r = 0;
        while(r<nums.length){
            if(nums[r]!=val){
                int temp = nums[r];
                nums[r] = nums[pos];
                nums[pos] = temp;
                pos++;
            }
            r++;
        }
        return pos;
    }
}