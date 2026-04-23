class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for(int i = 0;i<n;i++){
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
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int redundant = 0;
        for(int num[]:connections){
            int u = num[0];
            int v = num[1];
            redundant += ds.unionBySize(u,v);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            set.add(ds.findUPar(i));
        }
        int components = set.size()-1;
        if(redundant>=components) return components;
        return -1;

    }
}