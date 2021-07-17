class Solution {
    HashMap<String, Set<String>> map;
    HashMap<String, Integer> color;
    private void build(List<List<String>> similarPairs){
        int color = 0;
        for(List<String> pair : similarPairs){
            String s1 = pair.get(0);
            String s2 = pair.get(1);
            map.putIfAbsent(s1, new HashSet());
            map.putIfAbsent(s2, new HashSet());
            map.get(s1).add(s2);
            map.get(s2).add(s1);
        }
    }
    private boolean similar(String s1, String s2){    
        if(s1.equals(s2)) return true;
        if(!map.containsKey(s1) || !map.containsKey(s2)) return false;
        return color.get(s1) == color.get(s2);
    }
    private void dfs(String start, Set<String> visited, int currColor){
        color.put(start, currColor);
        visited.add(start);
        for(String adj : map.get(start)){
            if(!visited.contains(adj)){
                dfs(adj, visited, currColor);
            }
        }
    }
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        map = new HashMap();
        color = new HashMap();
        build(similarPairs);
        Set<String> visited = new HashSet();
        int currColor = 0;
        for(String key : map.keySet()){
            if(!visited.contains(key)){
                dfs(key, visited, ++currColor);
            }
        }
        int m = sentence1.length, n = sentence2.length;
        if(m != n) return false;
        for(int i = 0; i < m; i++){
            if(!similar(sentence1[i], sentence2[i])) return false;
        }
        return true;
    }
}