class Pair{
    long wt;
    int node;
    public Pair(long wt,int node){
        this.wt = wt;
        this.node = node;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int num[]:roads){
            int u = num[0];
            int v = num[1];
            long wt = num[2];
            adj.get(u).add(new Pair(wt,v));
            adj.get(v).add(new Pair(wt,u));
        }
        int mod = (int)1e9+7;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.wt,b.wt));
        long distance[] = new long[n];
        int ways[] = new int[n];
        Arrays.fill(distance,Long.MAX_VALUE);
        distance[0] = 0;
        ways[0] = 1;
        pq.offer(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            long wt = pair.wt;
            int node = pair.node;
            for(Pair num: adj.get(node)){
                long t = num.wt;
                int nextNode = num.node;
                if(wt>distance[node])continue;
                if(distance[nextNode]>t+wt){
                    distance[nextNode] = t+wt;
                    ways[nextNode] = (ways[node])%mod;
                    pq.offer(new Pair(distance[nextNode],nextNode));
                }else if(distance[nextNode]==t+wt){
                    ways[nextNode] = (ways[nextNode]+ways[node])%mod;
                }
            }
        }
        return (int)ways[n-1]%mod;

    }
} 