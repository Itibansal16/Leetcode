class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> q = new LinkedList();
        q.add(start);
        while(q.size() > 0){
            int front = q.poll();
            if(arr[front] == 0) return true;
            if(arr[front] == -1) continue;
            int op1 = front + arr[front];
            int op2 = front - arr[front];
            
            if(op1 < n){
                q.add(op1);
            } 
            if(op2 >= 0){
                q.add(op2);
            } 
            arr[front] = -1;
        }
        return false;
    }
}