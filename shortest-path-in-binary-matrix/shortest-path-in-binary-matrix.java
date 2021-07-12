class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        int[][] dir = {{1,0}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,-1}, {0,-1}, {-1,-1}};
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{0, 0});
        grid[0][0] = -1;
        int level = 1;
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                int[] front = q.poll();
                if(front[0] == m-1 && front[1] == n-1) return level;
                for(int a = 0; a <= 7; a++){
                    int dx = front[0] + dir[a][0];
                    int dy = front[1] + dir[a][1];
                    if(dx >= 0 && dy >= 0 && dx < m && dy < n && grid[dx][dy] == 0){
                        q.offer(new int[]{dx, dy});
                        grid[dx][dy] = -1;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}