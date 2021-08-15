class Solution {
    private void helper(TreeNode root, int level, List<Integer> rightView){
        if(root == null){
            return;
        }
        if(level == rightView.size()){
            rightView.add(root.val);
        }
        helper(root.right, level + 1, rightView);
        helper(root.left, level + 1, rightView);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList();
        helper(root, 0, rightView);
        return rightView;
    }
}