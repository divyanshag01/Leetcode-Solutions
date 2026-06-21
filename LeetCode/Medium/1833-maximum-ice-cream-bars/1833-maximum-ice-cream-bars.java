class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int cnt = 0;
        for(int num:costs){
            if(coins-num>=0){
                cnt++;
                coins-=num;
            }
        }
        return cnt;
    }
}