class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < asteroids.length; i++){
            //if there is no asteroid or asteroid is moving right or both asteroids are moving in left direction
            if(asteroids[i] > 0 || stack.isEmpty() || (asteroids[i] < 0 && stack.peek() < 0)){
                stack.push(asteroids[i]);
            }
            else{
                //pop all the asteroids which have opposite sign and value is lesser
                while(stack.size() > 0 && stack.peek() > 0 && stack.peek() < -asteroids[i]){
                    stack.pop();
                }
                
                //If last asteroid and current have same value then pop the last
                if(stack.size() > 0 && -asteroids[i] == stack.peek()){
                    stack.pop();
                }
                //if last asteroid is moving in same direction or there is no asteroid
                else if(stack.size() == 0 || stack.peek() < 0){
                    stack.push(asteroids[i]);
                }
            }
        }
        int[] ans = new int[stack.size()];
        int i = stack.size()-1;
        while(!stack.isEmpty()){
            ans[i--] = stack.pop();
        }
        return ans;
    }
}