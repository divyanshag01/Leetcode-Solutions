import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int dp[][] = new int[n][n];

        // Step 1: fill last row
        for(int j = 0; j < triangle.get(n-1).size(); j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        // Step 2: bottom-up calculation
        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[i][j] = triangle.get(i).get(j) +
                           Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        // Step 3: answer at top
        return dp[0][0];
    }
}