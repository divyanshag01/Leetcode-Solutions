class Pair{
    int wt;
    int node;
    public Pair(int wt,int node){
        this.wt = wt;
        this.node = node;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int num[]:times){
            int u = num[0];
            int v = num[1];
            int t = num[2];
            adj.get(u).add(new Pair(t,v));
        }
        int distance[] = new int[n+1];
        Arrays.fill(distance,-1);
        distance[0] = 0;
        distance[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.wt-b.wt);
        pq.offer(new Pair(0,k));
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int t = pair.wt;
            int node = pair.node;
            for(Pair num:adj.get(node)){
                int next = num.wt;
                int nextNode = num.node;
                if(distance[nextNode]==-1||distance[nextNode]>t+next){
                    distance[nextNode] = t+next;
                    pq.offer(new Pair(t+next,nextNode));
                }
            }
        }
        int sum =0;
        for(int i = 1;i<=n;i++){
            if(distance[i]==-1) return -1;
            sum=Math.max(distance[i],sum);
        }
        return sum;        
    }
}