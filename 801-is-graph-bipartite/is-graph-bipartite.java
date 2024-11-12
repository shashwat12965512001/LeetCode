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

    public static boolean isBipartite(int[][] G) {
        ArrayList<Edge>[] graph = createGraph(G.length);
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < G.length; i++) {
            for (int j = 0; j < G[i].length; j++) {
                addEdge(graph, i, G[i][j], 0);
            }
        }
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (color[e.dest] == -1) {
                            color[e.dest] = color[curr] == 0 ? 1 : 0;
                            q.add(e.dest);
                        }else if (color[e.dest] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}