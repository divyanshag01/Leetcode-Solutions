class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int v = 0;

            if (s.charAt(i) == 'I') v = 1;
            else if (s.charAt(i) == 'V') v = 5;
            else if (s.charAt(i) == 'X') v = 10;
            else if (s.charAt(i) == 'L') v = 50;
            else if (s.charAt(i) == 'C') v = 100;
            else if (s.charAt(i) == 'D') v = 500;
            else if (s.charAt(i) == 'M') v = 1000;

            if (i + 1 < n) {
                int next = 0;
                if (s.charAt(i + 1) == 'I') next = 1;
                else if (s.charAt(i + 1) == 'V') next = 5;
                else if (s.charAt(i + 1) == 'X') next = 10;
                else if (s.charAt(i + 1) == 'L') next = 50;
                else if (s.charAt(i + 1) == 'C') next = 100;
                else if (s.charAt(i + 1) == 'D') next = 500;
                else if (s.charAt(i + 1) == 'M') next = 1000;

                if (v < next) ans -= v;
                else ans += v;
            } else {
                ans += v;
            }
        }
        return ans;
    }
}
