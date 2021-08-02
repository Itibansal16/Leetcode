class Solution {
    int find(int[] parent , int i){
        if(parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;
        for(int i = 0; i < n; i++){
            int srcP = find(parent, i);
            if(leftChild[i] != -1){
              if(parent[leftChild[i]] != leftChild[i]) return false;
              int destP = find(parent, leftChild[i]);
              if(srcP == destP)
                  return false;
              parent[destP] = srcP;  
            }
            if(rightChild[i] != -1){
                if(parent[rightChild[i]] != rightChild[i]) return false;
                int destP = find(parent, rightChild[i]);
              if(srcP == destP)
                  return false;
              parent[destP] = srcP; 
            }
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