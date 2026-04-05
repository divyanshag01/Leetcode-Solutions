class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[numCourses];
        for(int edge[]:prerequisites){
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(indegree[i]==0)q.offer(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int num:adj.get(node)){
                indegree[num]--;
                if(indegree[num]==0)q.offer(num);
            }
        }
        if(res.size()!=numCourses) return(new int[0]);
        int arr[] = new int[res.size()];
        for(int i = 0;i<res.size();i++){
            arr[i] = res.get(i);
        }
        return arr;
    }
}