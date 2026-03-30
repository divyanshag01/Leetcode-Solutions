class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // int vis[][] = new int[image.length][image[0].length];
        if(image[sr][sc]==color) return image;
        solve(image,sr,sc,image[sr][sc],color);
        return image;
    }
    public void solve(int[][] image,int sr,int sc,int initial,int color){
        image[sr][sc]=color;
        int drow[] = {0,-1,0,+1};
        int dcol[] = {-1,0,+1,0};
        for(int i = 0;i<4;i++){
            int nrow = sr + drow[i]; 
            int ncol = sc + dcol[i];
            if(nrow>=0 && nrow<image.length && ncol>=0 && ncol<image[0].length && image[nrow][ncol]==initial){
                solve(image,nrow,ncol,initial,color);
            } 
        }
        return;
    }
}