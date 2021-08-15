class Solution {
    int[] dp;
    private int helper(char[] message, int i){
        if(i == message.length) return 1;
        if(dp[i] != -1) return dp[i];
        int ans = 0;
        if(message[i] != '0'){
            ans += helper(message, i+1);
        }
        if(i+1 < message.length){
            int num = (message[i] - '0') * 10 + (message[i+1] - '0');
            if(num >= 10 && num <= 26){
                ans += helper(message, i + 2);
            }
        }
        return dp[i] = ans;
    }
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s.toCharArray(), 0);
    }
}