/*
  APPROACH 1: DP-O(NK)
  APPROACH 2: Sliding Window-O(N): It can be observed that for every window of size k, we need the maximum. So this problem is similar to sliding window maximum       
*/
class Solution {
    public int maxResult(int[] nums, int k) {
	    Deque<Integer> q = new LinkedList<Integer>();
	    for (int i = 0; i < nums.length; i++) {
		    //update nums[i] value with maximum score to reach till i
		    int max = q.size() == 0 ? 0 : nums[q.peekFirst()];
		    nums[i] += max;

		    //validate the window of size k
		    if(q.size() > 0 && i - q.peek() + 1 > k) q.pollFirst();

		    //remove minimum values
		    while(q.size() > 0 && nums[q.peekLast()] < nums[i]) q.pollLast();

		    q.offer(i);
            
	    }
	    return nums[nums.length - 1];
    }
}
