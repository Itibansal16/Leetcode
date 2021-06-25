class Solution {
    private int find(int[] parent, int a){
        if(parent[a] == a)
            return a;
        return find(parent, parent[a]);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        for(int i = 0; i <= n; i++)
            parent[i] = i;
        for(int i = 0; i < edges.length; i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            int srcParent = find(parent, src);
            int destParent = find(parent, dest);
            if(srcParent == destParent)
                return edges[i];
            else
                parent[srcParent] = destParent;
        }
        return new int[0];
    }
}