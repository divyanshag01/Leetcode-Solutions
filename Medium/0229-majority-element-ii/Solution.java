class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0;
        int c2 = 0;
        int cnt1 = 0, cnt2 = 0;
        for(int n: nums){
            if(n == c1)cnt1++;
            else if(n==c2) cnt2++;
            else if(cnt1==0) {
                c1 = n;
                cnt1++;
            }
            else if(cnt2==0){
                c2 = n;
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for(int n: nums){
            if(n == c1) cnt1++;
            else if(n==c2) cnt2++;
        }
        List<Integer> ans = new ArrayList<>();
        if(cnt1>(nums.length/3))ans.add(c1);
        if(cnt2>(nums.length/3))ans.add(c2);
        return ans;
    }
}