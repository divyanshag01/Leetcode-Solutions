class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
     int n = landStartTime.length;
     int m = waterStartTime.length;
     int minLandEnd = Integer.MAX_VALUE;
     int minWaterEnd = Integer.MAX_VALUE;
     for(int i = 0;i<n;i++){
        minLandEnd = Math.min(minLandEnd,landStartTime[i]+landDuration[i]);
     }
     int landWater = Integer.MAX_VALUE;
     for(int i = 0;i<m;i++){
        landWater = Math.min(landWater,Math.max(minLandEnd,waterStartTime[i])+waterDuration[i]);
     }
     for(int i = 0;i<m;i++){
        minWaterEnd = Math.min(minWaterEnd,waterStartTime[i]+waterDuration[i]);
     }
     int waterLand = Integer.MAX_VALUE;
     for(int i = 0;i<n;i++){
        waterLand = Math.min(waterLand,Math.max(minWaterEnd,landStartTime[i])+landDuration[i]);
     }
     return Math.min(landWater,waterLand);
     
    }
}