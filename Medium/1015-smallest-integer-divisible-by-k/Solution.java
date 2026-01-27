class Solution {
    public int smallestRepunitDivByK(int k) {
        int cnt = 1;
        int flag = 0;
        int n = 1;
        if(k%2==0 || k%5==0){
            return -1;
        }
        while(flag==0){
            if(n%k==0){
                flag=1;
                return cnt;
            }
            else{
                n=(n*10 +1)%k;
                cnt++;
            }
        }
        return cnt;
    }
}