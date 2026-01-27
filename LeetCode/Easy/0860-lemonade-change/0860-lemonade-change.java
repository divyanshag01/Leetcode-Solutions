class Solution {
    public boolean lemonadeChange(int[] bills) {
        // int sum = 0;
        int n = 0;
        int p = 0;
        // int q = 0;
        for(int i = 0;i<bills.length;i++){
            if(bills[i]-5==0){
                // sum+=bills[i];
                n++;
            }else{
                int diff = bills[i]-5;
                if(diff==5){
                    if(n==0)return false;
                    n--;
                    p++;
                }else{
                    if(n>0 && p>0){
                        n--;
                        p--;
                    }else if(n>=3){
                        n-=3;
                    }else{
                        return false;
                    }
                }

            }
        }
        return true;
    }
}