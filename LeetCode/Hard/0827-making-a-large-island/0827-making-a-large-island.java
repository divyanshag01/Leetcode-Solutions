class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for(int i = 0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findUPar(int u){
        if(u==parent.get(u)){
            return u;
        }
        int ulp = findUPar(parent.get(u));
        parent.set(u,ulp);
        return parent.get(u);
    }
    public int unionBySize(int u,int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u==ulp_v)return 1;
        if(size.get(ulp_u)>size.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
            return 0;
        }else{
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
            return 0;
        }
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        int drow[] = {1,0,-1,0}; 
        int dcol[] = {0,1,0,-1};
        int n = grid.length;
        int m = grid[0].length;
        DisjointSet ds = new DisjointSet(n*m);
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==0) continue;
                int u = i*m +j;
                for(int k = 0;k<4;k++){
                    int nr = i + drow[k];
                    int nc = j + dcol[k];
                    if(nr>=0 && nc >= 0 && nr<n && nc<m && grid[nr][nc]==1){
                        int v = nr*m + nc;
                        ds.unionBySize(u,v);
                    }
                }
            }
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1)continue;
                HashSet<Integer> set = new HashSet<>();
                int cnt = 1;
                for(int k = 0;k<4;k++){
                    int nr = i + drow[k];
                    int nc = j + dcol[k];
                    if(nr>=0 && nc >= 0 && nr<n && nc<m && grid[nr][nc]==1){
                        int v = nr*m + nc;
                        int utp = ds.findUPar(v);
                        if(!set.contains(utp)){
                            set.add(utp);
                            cnt += ds.size.get(utp);
                        }
                    }
                }
                max = Math.max(max,cnt);
            }
        }
        return max==0?n*m:max;
    }
}