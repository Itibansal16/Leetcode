class DLLNode{
    int key, val;
    DLLNode next, prev;
    public DLLNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    HashMap<Integer, DLLNode> map;
    DLLNode head, tail;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        DLLNode node = map.get(key);
        removeNode(node);
        insertNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key) && capacity <= map.size()){
            removeLast();
        }
        if(map.containsKey(key)){
            DLLNode node = map.get(key);
            node.val = value;
            removeNode(node);
            insertNode(node);
        }
        else{
            DLLNode node = new DLLNode(key, value);
            map.put(key, node);
            insertNode(node);
        }
    }
    private void removeLast(){
        DLLNode last = tail.prev;
        tail.prev = last.prev;
        tail.prev.next = tail;
        
        map.remove(last.key);
    }
    private void removeNode(DLLNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
    }
    private void insertNode(DLLNode node){
        DLLNode next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */