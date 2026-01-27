class Solution {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> ans = new ArrayList<>();
        int n = intervals.length;
        int cur[] = new int[2];
        cur[0] = intervals[0][0];
        cur[1]= intervals[0][1];
        for(int i = 1;i<n;i++){
            if(cur[1]>=intervals[i][0]){
                cur[1]=Math.max(cur[1],intervals[i][1]);
            }else{
                ans.add(Arrays.asList(cur[0],cur[1]));
                cur[0] = intervals[i][0];
                cur[1] = intervals[i][1];
            }          

        }
        ans.add(Arrays.asList(cur[0],cur[1]));
        int[][] result = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }
        return result;

    }
}