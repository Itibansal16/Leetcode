/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int[] outdegree = new int[n];
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(knows(i, j)){
                   outdegree[i]++;
                   indegree[j]++; 
                } 
            }
        }
        int celebrity = -1;
        for(int i = 0; i < n; i++){
            if(outdegree[i] == 0 && indegree[i] == n-1){
               if(celebrity != -1) return -1;
               celebrity = i; 
            } 
        }
        return celebrity;
    }
}