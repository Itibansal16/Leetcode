class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = s.length()-1; i >= 0; i--){
            dp[i][i] = true;
            for(int j = i+1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && ((j-i) <= 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                }
            }
        }
        for(int j = 0; j < s.length()-2; j++){
            if(dp[0][j]){
                for(int k = j+1; k < s.length()-1; k++){
                    if(dp[j+1][k] && dp[k+1][n-1]){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}