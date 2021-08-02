class Solution {
    private Node cloneHelper(Node node, HashMap<Node, Node> map){
        if(node == null) return node;
        
        if(map.containsKey(node)){
            return map.get(node);
        }
        
        Node cloned = new Node(node.val, new ArrayList());
        
        map.put(node, cloned);
        for(Node neigh : node.neighbors){
            cloned.neighbors.add(cloneHelper(neigh, map));
        }
        
        return cloned;
    }
    public Node cloneGraph(Node node) {
        return cloneHelper(node, new HashMap());
    }
}