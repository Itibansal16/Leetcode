//APPROACH -1 : DP
/* 
   BFS: store 0th index initially then store all those indexes which can be reachable from curr index. Worst case can be O(n^2).
   for every index i, we have to run a loop from i+minJump to i+maxJump but we can reduce this loop.
   We are visiting a lot of indexes repeatedly, so to keep track of the indexes already visited we can keep a variable maxReached which will store the rightmost index we have reached. then for every i, start loop from maxReached to i+maxJump
*/
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        Queue<Integer> q = new LinkedList();
        q.add(0);
        int maxReached = 0;
        while(q.size() > 0){
            int front = q.poll();
            if(front == n - 1) return true;
            
            int start = Math.max(front + minJump, maxReached + 1);
            int end = Math.min(front + maxJump, n - 1);
            for(int i = start; i <= end; i++){
                if(s.charAt(i) == '0') q.offer(i);
            }
            maxReached = Math.max(maxReached, front + maxJump);
        }
        return false;
        
        
        // char[] arr = s.toCharArray();
        // int n = arr.length;
        // boolean[] dp = new boolean[n];
        // dp[0] = true;
        // for(int i = 0; i < n; i++){
        //     if(arr[i] == '1') continue;
        //     if(!dp[i]) continue;
        //     for(int j = i+minJump; j <= i + maxJump && j < n; j++){
        //         if(arr[j] == '0') dp[j] = true;
        //     }
        // }
        // //System.out
        // return dp[n-1];
    }
}