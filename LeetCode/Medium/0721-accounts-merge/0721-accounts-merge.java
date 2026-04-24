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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> map = new HashMap<>();
        List<List<String>> mailList = new ArrayList<>();
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        for(int i = 0;i<n;i++){
            mailList.add(new ArrayList<>());
            for(int j = 1;j<accounts.get(i).size();j++){
                if(!map.containsKey(accounts.get(i).get(j))){
                    map.put(accounts.get(i).get(j),i);
                }else{
                    ds.unionBySize(i,map.get(accounts.get(i).get(j)));
                }
            }
        }
        for(Map.Entry<String,Integer> it : map.entrySet()){
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mailList.get(node).add(mail);
        }
        List<List<String>> mail = new ArrayList<>();
        int k = 0;
        for(int i = 0;i<n;i++){
            Collections.sort(mailList.get(i));
            if(mailList.get(i).size()!=0){
                mail.add(new ArrayList<>());
                mail.get(k).add(accounts.get(i).get(0));
                for(int j = 0;j<mailList.get(i).size();j++){
                    mail.get(k).add(mailList.get(i).get(j));
                }
                k++;
            }
        }
        return mail;
    }
}