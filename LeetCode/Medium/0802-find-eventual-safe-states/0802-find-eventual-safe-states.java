class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       List<Integer> res = new ArrayList<>();
       Queue<Integer> q = new LinkedList<>();
       int n = graph.length;
       int indegree[] = new int[n];
       for(int i = 0;i<n;i++){
        adj.add(new ArrayList<>()); 
       } 
       for(int i = 0;i<n;i++){
        for(int num:graph[i]){
            adj.get(num).add(i);
            indegree[i]++;
        }
       }
       for(int i = 0;i<n;i++){
        if(indegree[i]==0)q.offer(i);
       } 
       while(!q.isEmpty()){
        int node = q.poll();
        res.add(node);
        for(int num:adj.get(node)){
            indegree[num]--;
            if(indegree[num]==0)q.offer(num);
        }
       }
       Collections.sort(res);
       return res;
    }
}