class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String s : tokens){
            if(s.equals("+")){
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                stack.push(num1 + num2);
            }
            else if(s.equals("-")){
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                stack.push(num2 - num1);
            }
            else if(s.equals("*")){
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                stack.push(num1 * num2);
            }
            else if(s.equals("/")){
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                stack.push(num2 / num1);
            }
            else stack.push(Integer.valueOf(s));
        }
        return stack.pop();
    }
}