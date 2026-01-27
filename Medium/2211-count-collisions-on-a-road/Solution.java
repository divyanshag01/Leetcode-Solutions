class Solution {
    public int countCollisions(String directions) {
        int l = 0;
        int r = directions.length()-1;
        int cnt = 0;
        // int n = directions.length();
        while(l<=r && directions.charAt(l)=='L'){
            l++;
        }
        while(r>=l && directions.charAt(r)=='R'){
            r--;
        }
        while(l<=r){
            if(directions.charAt(l)=='S'){
                l++;
                continue;
            }
            cnt++;
            l++;

        }
        return cnt;
    }
}