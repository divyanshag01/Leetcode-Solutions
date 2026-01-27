import java.util.*;
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        int max = 0;
        while(r<n){
            if(nums[r]==0){
                l = r+1;
            }
            max = Math.max(max,r-l+1);
            r++;

        }
        return max;
    }
}