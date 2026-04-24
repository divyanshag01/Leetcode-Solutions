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
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for(int num[]:stones){
            maxRow = Math.max(maxRow,num[0]);
            maxCol = Math.max(maxCol,num[1]);
        }
        DisjointSet ds = new DisjointSet(maxRow+maxCol+1);
        HashSet<Integer> set = new HashSet<>();
        for(int num[]:stones){
            int row = num[0];
            int col = num[1]+maxRow+1;
            ds.unionBySize(row,col);
            set.add(row);
            set.add(col);
        }
        int connected = 0;
        for(int num:set){
            if(ds.findUPar(num)==num) connected++;
        }
        return stones.length-connected;
    }
}