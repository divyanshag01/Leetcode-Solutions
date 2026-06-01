class Solution {
    public int minimumCost(int[] cost) {
        int min = 0;
        Arrays.sort(cost);
        // if(cost.length==1)return cost[0];
        for(int i = cost.length-1;i>=0;i--){
            if(i-2>=0){
                min += cost[i]+cost[i-1];
                i--;
                i--;
                continue;
            }else{
                min += cost[i];
            }
        }
        return min;
    }
}