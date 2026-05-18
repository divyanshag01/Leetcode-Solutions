class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max = bloomDay[0];
        for(int num:bloomDay){
            max = Math.max(max,num);
        }
        int l = 1;
        int r = max;
        int ans = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(check(bloomDay,mid,k,m)){
                r = mid-1;
                ans = mid;
            }else{
                l = mid+1;
            }
            
        }
        return ans;
    }
    public boolean check(int bloomDay[],int mid, int k,int m){
        int cnt = 0;
        int flower = 0;
        for(int num:bloomDay){
            if(num<=mid){
                flower++;
                if(flower==k){
                    flower = 0;
                    cnt++;
                }
            }else{
                flower =0;
            }
        }
        if(cnt>=m) return true;
        return false; 
    }
}