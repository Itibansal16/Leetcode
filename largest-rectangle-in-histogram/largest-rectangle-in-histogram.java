class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int maxArea = -1;
        int n = heights.length;
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int top = stack.pop();
                int currArea = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, currArea);
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int top = stack.pop();
            int currArea = heights[top] * (stack.isEmpty() ? n : n - stack.peek() - 1);
            maxArea = Math.max(maxArea, currArea);
        }
        
        return maxArea;
    }
}