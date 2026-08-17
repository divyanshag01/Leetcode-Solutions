class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int max = 0;
        for(int num:piles) max = Math.max(max,num);
        int r = max;
        int ans = max;
        // if(h>=max)
        while(l<=r){
            int mid = l + (r-l)/2;
            if(check(mid,piles,h)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    public static boolean check(int ans,int piles[],int h){
        long cnt = 0;
        for(int num:piles){
            int div = (int)Math.ceil((double)num/ans);
            cnt+=div;
        }
        if(cnt<=h) return true;
        return false;
    }
}