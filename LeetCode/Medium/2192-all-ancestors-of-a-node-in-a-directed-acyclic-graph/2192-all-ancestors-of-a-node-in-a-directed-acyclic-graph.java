class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<TreeSet<Integer>> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        boolean vis[] = new boolean[n];
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
            ans.add(new TreeSet<>());
        }
        int indegree[] = new int[n];
        for(int num[]:edges){
            int u = num[0];
            int v = num[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(int num:adj.get(node)){
                indegree[num]--;
                ans.get(num).add(node);
                for(int i:ans.get(node)){
                    ans.get(num).add(i);
                }
                if(indegree[num]==0){
                    q.add(num);
                }
            }
        }
        List<List<Integer>> res = new  ArrayList<>();
        for(int i = 0;i<n;i++){
            List<Integer> curr = new ArrayList<>(ans.get(i));
            res.add(curr);
        }
        return res;
    }
}