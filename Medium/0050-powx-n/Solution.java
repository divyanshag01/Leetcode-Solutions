class Solution {
    public double power(double x,int n){
        if(n==0){
            return 1.0;
        }
        double half = power(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
}
    public double myPow(double x, int n) {
        if(x==0D){
            return 0D;
        }
        if(n==0){
            return 1D;
        }
        if(n<0){
            x = 1/x;
            n = -n;
        }
        return power(x,n);
    }
}