
/*
Explanation:
There are n cities and m edges connected by some number of flights. Given an array of flights where flights[i] = [ fromi, toi, pricei] indicates that there is a flight from city fromi to city to with cost price. Given three integers src, dst, and k, and return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
*/

class Solution {
    public int CheapestFlight(int n, int[][] flights, int src, int dst, int K) {
        if(src==dst)
        return 0;
       List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, src, 0});
        while(!q.isEmpty()){
            int[]p=q.poll();
            int stops=p[0];
            int node=p[1];
            int dist=p[2];
            if(stops> K)
            continue;
            for(int[]neighbor:adj.get(node)){
                int adjNode=neighbor[0];
                int edgeWt=neighbor[1];
                if(dist+edgeWt<minDist[adjNode] && stops<=K){
                    minDist[adjNode]=dist+edgeWt;
                    q.add(new int[]{stops+1,adjNode,minDist[adjNode]});
                }
            }
        }
        if(minDist[dst]==Integer.MAX_VALUE)
        return -1;
        return minDist[dst];
    }
}


