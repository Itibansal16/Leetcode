class Solution {
    Set<String> givenWords;
    Set<String> prefix;
    Set<String> ans;
    boolean[][] visited;
    private void dfs(char[][] board, int i, int j, String currWord){
        if(givenWords.contains(currWord)){
            ans.add(currWord);
           // return;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]){
            
            return;
        }
        
       // System.out.println(currWord + " " + i + " " + j);
        if(!prefix.contains(currWord)) return;
        char c = board[i][j];
        visited[i][j] = true;
        dfs(board, i+1, j, currWord+c);
        dfs(board, i-1, j, currWord+c);
        dfs(board, i, j+1, currWord+c);
        dfs(board, i, j-1, currWord+c);
        visited[i][j] = false;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        visited = new boolean[board.length][board[0].length];
        
        givenWords = new HashSet();
        prefix = new HashSet();
        ans = new HashSet();
        prefix.add("");
        for(String w : words) givenWords.add(w);
        for(String w : words){
            for(int i = 0; i < w.length(); i++){
                prefix.add(w.substring(0,i));
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, "");
            }
        }
        return new ArrayList(ans);
    }
}