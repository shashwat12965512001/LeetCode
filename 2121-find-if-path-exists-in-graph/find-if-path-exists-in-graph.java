class Solution {

    static class Edge {
        int src, dest, wt;
        public Edge (int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static ArrayList<Edge>[] createGraph(int V) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        return graph;
    }

    public static ArrayList<Edge>[] addEdge(ArrayList<Edge>[] graph, int src, int dst, int wt) {
        graph[src].add(new Edge(src, dst, wt));
        return graph;
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean visited[]) {
        if (src == dest) {
            return true;
        }
        visited[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!visited[e.dest] && hasPath(graph, e.dest, dest, visited)) {
                return true;
            }
        }
        return false;
    }

    public static void DFSUtil(ArrayList<Edge>[] graph, int curr, boolean visited[]) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                DFSUtil(graph, e.dest, visited);
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge>[] graph = createGraph(n);
        for (int i = 0; i < edges.length; i++) {
            addEdge(graph, edges[i][0], edges[i][1], 0);
            addEdge(graph, edges[i][1], edges[i][0], 0);
        }
        boolean visited[] = new boolean[n];
        DFSUtil(graph, source, visited);
        return visited[destination];
        // return hasPath(graph, source, destination, visited);
    }
}