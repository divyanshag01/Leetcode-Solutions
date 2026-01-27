class Solution {
    static final long MOD = 1_000_000_007;

    public long power(long x,long n,long ans){
    if(n==0){
        return ans;
    }
    if(n%2==0){
        x=(x*x)%MOD;
        n = n/2;
        return power(x,n,ans);
    }else{
        ans =(ans * x)%MOD;
        n = n-1;
        return power(x,n,ans);            
    }
}
    public int countGoodNumbers(long n) {
        if(n%2==0){
            long a = power(5,n/2,1);
            long b = power(4,n/2,1);
            return (int)((a*b)%MOD);
        }else{
            long a = power(5,(n/2)+1,1);
            long b = power(4,n/2,1);
            return (int)((a*b)%MOD);
        }
    }
}