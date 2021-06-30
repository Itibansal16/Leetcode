class TrieNode{
    String word;
    TrieNode[] children;
    boolean isTerminating;
    public TrieNode(){
        children = new TrieNode[26];
        word = "";
        isTerminating = false;
    }
    public void insert(TrieNode root, char[] word, int i){
        if(word.length == i){
            root.word = new String(word);
            root.isTerminating = true;
            return;
        }
        if(root.children[word[i] - 'a'] == null){
            root.children[word[i] - 'a'] = new TrieNode();
        }
        insert(root.children[word[i] - 'a'], word, i+1);
    }
}
class Solution {
    Set<String> ans;
    private void dfs(char[][] board, int i, int j, TrieNode root){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#'){
            return;
        }
        TrieNode child = root.children[board[i][j] - 'a'];
        if(child == null) return;
        if(child.isTerminating){
            ans.add(child.word);
        }
              
        char temp = board[i][j];
        board[i][j] = '#';
        dfs(board, i+1, j, child);
        dfs(board, i-1, j, child);
        dfs(board, i, j+1, child);
        dfs(board, i, j-1, child);
        board[i][j] = temp;
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        ans = new HashSet();
        for(String word : words){
            root.insert(root, word.toCharArray(), 0);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root);
            }
        }
        return new ArrayList(ans);
    }
}