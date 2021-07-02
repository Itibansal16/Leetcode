class Solution {
    public int minJumps(int[] arr) {
        //Store the indices of all the elements
        int n = arr.length;
        if(n <= 1) return 0;
        HashMap<Integer, List<Integer>> map = new HashMap();
        for(int i = 0; i < n; i++){
            map.putIfAbsent(arr[i], new ArrayList());
            map.get(arr[i]).add(i);
        }
        
        //from index i: we have these options to go i+1, i-1, all indices present in map.get(arr[i])
        //BFS
        Queue<Integer> q = new LinkedList();
        q.add(0);
        int steps = 0;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                int front = q.poll();
                if(front == n-1) return steps;
                List<Integer> neighbors = map.get(arr[front]);
                for(int neighbor : neighbors){
                    if(!visited[neighbor]){
                        q.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
                if(front + 1 < n && !visited[front + 1]){
                    q.add(front + 1);
                    visited[front + 1] = true;
                }
                if(front - 1 >= 0 && !visited[front - 1]){
                    q.add(front - 1);
                    visited[front - 1] = true;
                }
                neighbors.clear();//IMPORTANT STEP because we have already visited all the indices in neighbors. Otherwise, it will result in TLE.
            }
            steps++;
        }
        return steps;
    }
}