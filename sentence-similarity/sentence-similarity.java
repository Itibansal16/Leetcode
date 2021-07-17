class Solution {
    Map<String, Set<String>> map;
    private void build(List<List<String>> similarPairs){
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
        if(!map.containsKey(s1) && !map.containsKey(s2)) return false;
        if(map.containsKey(s1)) return map.get(s1).contains(s2);
        if(map.containsKey(s2)) return map.get(s2).contains(s1);
        return false;
    }
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        map = new HashMap();
        build(similarPairs);
        int m = sentence1.length, n = sentence2.length;
        if(m != n) return false;
        for(int i = 0; i < m; i++){
            if(!similar(sentence1[i], sentence2[i])) return false;
        }
        return true;
    }
}