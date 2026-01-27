class Solution {
    public int mySqrt(int x) {
        int y = (int)Math.pow(x,0.5);
        int k = (int)Math.floor(y);
        return k;
    }
}