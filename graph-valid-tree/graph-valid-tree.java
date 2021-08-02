class Solution {
    private int find(int[] parent, int i){
        if(parent[i] == i) return i;
        return find(parent, parent[i]);
    }
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int[] edge : edges){
            int srcParent = find(parent, edge[0]);
            int destParent = find(parent, edge[1]);
            if(srcParent == destParent) return false;
            parent[destParent] = srcParent;
        }
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(parent[i] == i){
                if(flag) return false;
                flag = true;
            }
        }
        return flag;
    }
}