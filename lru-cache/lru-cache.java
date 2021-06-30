class DLLNode{
    int key, val;
    DLLNode prev, next;
    DLLNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    HashMap<Integer, DLLNode> map;
    DLLNode head, tail;
    int capacity;
    private void insert(DLLNode node){
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    private void remove(DLLNode node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLLNode node = map.get(key);
        if(node == null) return -1;
        remove(node);
        insert(node);
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insert(new DLLNode(key, value));
    }
}

