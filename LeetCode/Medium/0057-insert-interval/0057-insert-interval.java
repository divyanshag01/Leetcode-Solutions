class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int copy[][] = Arrays.copyOf(intervals,intervals.length+1);
        copy[intervals.length] = newInterval;
        Arrays.sort(copy,(a,b)->Integer.compare(a[0],b[0]));
        int n = copy.length;
        List<List<Integer>> ans = new ArrayList<>();
        int start = copy[0][0]; 
        int end = copy[0][1];
        for(int i = 1;i<n;i++){
            if(copy[i][0]<=end){
                end = Math.max(copy[i][1],end);
            }
            if(copy[i][0]>end){
                // end = Math.max(copy[i][1],end);
                ans.add(new ArrayList<>(Arrays.asList(start,end)));
                start = copy[i][0];
                end = copy[i][1];
            }
        }
        ans.add(new ArrayList<>(Arrays.asList(start,end)));
        int res[][] = new int[ans.size()][2];
        for(int i = 0;i<ans.size();i++){
            for(int j = 0;j<2;j++){
                res[i][j] = ans.get(i).get(j);
            }
        }
        return res;
    }
}