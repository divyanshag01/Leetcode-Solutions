class Pair{
    int wt;
    int node;
    public Pair(int wt,int node){
        this.wt = wt;
        this.node = node;
    }
}
class Tuple{
    int stop;
    int node;
    int wt;
    public Tuple(int stop,int wt,int node){
        this.stop = stop;
        this.node = node;
        this.wt = wt;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int num[]:flights){
            int u = num[0];
            int v = num[1];
            int cost = num[2];
            adj.get(u).add(new Pair(cost,v));
        }
        int distance[] = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0,0,src));
        distance[src] = 0;
        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            int wt = tuple.wt;
            int stop = tuple.stop;
            int node = tuple.node;
            // visited[node] = true;

            if(stop>k){
                continue;
            }
            for(Pair num:adj.get(node)){
                int cost = num.wt;
                int nextNode = num.node;
                if(cost+wt<distance[nextNode] ){
                    distance[nextNode] = cost+wt;
                    q.offer(new Tuple(stop+1,cost+wt,nextNode));
                }
            }
        }
        return distance[dst]==Integer.MAX_VALUE?-1:distance[dst];

    }
}