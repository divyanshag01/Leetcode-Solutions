class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int max = 0;
        int sum = 0;

        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }

        int l = max;
        int r = sum;

        int ans = sum;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (canShip(weights, mid, days)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public boolean canShip(int[] weights, int capacity, int days) {

        int usedDays = 1;
        int curr = 0;

        for (int w : weights) {

            if (curr + w > capacity) {
                usedDays++;
                curr = w;
            } else {
                curr += w;
            }
        }

        return usedDays <= days;
    }
}