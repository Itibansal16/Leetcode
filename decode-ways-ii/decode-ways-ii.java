class Solution {
    long[] dp;
    private long helper(char[] message, int i){
        if(i == message.length) return 1;
        if(dp[i] != -1) return dp[i];
        long ans = 0;
        if(message[i] != '0'){
            ans += helper(message, i+1);
            if(message[i] == '*'){
                ans *= 9;
            }
        }
        if(i + 1 < message.length){
            if(message[i] == '*'){
                if(message[i+1] == '*'){
                    ans += 15*helper(message, i+2);
                }
                else{
                    ans += message[i+1] <= '6' ? 2*helper(message, i+2) :
                                                  helper(message, i+2);
                }
            }
            else{
                if(message[i+1] == '*'){
                    if(message[i] == '1'){
                        ans += 9*helper(message, i+2);
                    }
                    else if(message[i] == '2'){
                        ans += 6*helper(message, i+2);
                    }
                }
                else{
                    int num = (message[i] - '0') * 10 + (message[i+1] - '0');
                    if(num >= 10 && num <= 26){
                        ans += helper(message, i+2);
                    }
                }
            }
        }
        
        
        return dp[i] = ans % 1000000007;
    }
    public int numDecodings(String s) {
        dp = new long[s.length()];
        Arrays.fill(dp, -1);
        return (int)helper(s.toCharArray(), 0);
    }
}