class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int n: nums){
            if(n == 0) zero++;
            if(n == 1) one++;
            if(n== 2) two++;
        }
        int idx = 0;
        while(zero-->0) nums[idx++]=0;
        while(one-->0) nums[idx++]=1;
        while(two-->0) nums[idx++] = 2;
     }
}