import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();
        int[] merged = new int[]{newInterval[0], newInterval[1]};
        boolean inserted = false;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < merged[0]) {
                ans.add(intervals[i]);
            }
            else if (intervals[i][0] > merged[1]) {
                if (!inserted) {
                    ans.add(merged);
                    inserted = true;
                }
                ans.add(intervals[i]);
            }
            else {
                merged[0] = Math.min(merged[0], intervals[i][0]);
                merged[1] = Math.max(merged[1], intervals[i][1]);
            }
        }
        if (!inserted) {
            ans.add(merged);
        }
        int[][] result = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}
