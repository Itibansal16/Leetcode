class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while(curr != null || stack.size() > 0){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode top = stack.peek();
            if(top.right != null){
                curr = top.right;
            }
            else{
                top = stack.pop();
                ans.add(top.val);
                while(stack.size() > 0 && stack.peek().right == top){
                    top = stack.pop();
                    ans.add(top.val);
                }
            }
        }
        return ans;
    }
}