class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        HashMap<Node, Node> map = new HashMap();
        Node curr = head;
        
        while(curr != null){
            if(!map.containsKey(curr)){
                map.put(curr, new Node(curr.val));
            }
            if(curr.next != null && !map.containsKey(curr.next)){
                map.put(curr.next, new Node(curr.next.val));
            }
            if(curr.random != null && !map.containsKey(curr.random)){
                map.put(curr.random, new Node(curr.random.val));
            }
            
            Node clone = map.get(curr);
            clone.next = map.get(curr.next);
            clone.random = map.get(curr.random);
            
            curr = curr.next;
        }
        
        return map.get(head);
    }
}