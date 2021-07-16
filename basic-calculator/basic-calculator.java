class Solution {
    public int calculate(String s) {
        Stack<Integer> sign = new Stack();
        sign.push(1);
        sign.push(1);
        int i = 0;
        int ans = 0;
        while(i < s.length()){
            char c =s.charAt(i);
            if(Character.isDigit(s.charAt(i))){
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ans += sign.peek()*num;
                sign.pop();
            }
            
            else if(c == ')'){
                sign.pop();
                i++;
            }
            else if(c == '+' || c == '('){
                sign.push(1*sign.peek());
                i++;
            }
            else if(c == '-'){          
                sign.push(-1*sign.peek());
                i++;
            }
            else i++;
        }
        return ans;
    }
}