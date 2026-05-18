class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // if(piles.length==1){
        //     if(h>=piles[0]) return 1;
        //     else 
        // }
        int l = 1;
        int ans = Arrays.stream(piles).max().getAsInt();;
        int r = ans;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(check(piles,mid,h)){
                ans = mid;
                r=mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    public boolean check(int piles[],int mid,int h){
        for(int num:piles){
           if(num<=mid) h--;
           else if(num%mid==0) h-=num/mid;
           else h = h -(num/mid +1);
        }
        return h>=0?true:false;
    }
}