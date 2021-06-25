class Solution {
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans;
    private void helper(char[] digits, int i, StringBuilder temp){
        if(i == digits.length){
            ans.add(temp.toString());
            return;
        }
        int digit = digits[i] - '0';
        for(char letter : map[digit].toCharArray()){
            temp.append(letter);
            helper(digits, i+1, temp);
            temp.deleteCharAt(temp.length()-1);
        }
        
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList();
        ans = new ArrayList();
        helper(digits.toCharArray(), 0, new StringBuilder());
        return ans;
    }
}