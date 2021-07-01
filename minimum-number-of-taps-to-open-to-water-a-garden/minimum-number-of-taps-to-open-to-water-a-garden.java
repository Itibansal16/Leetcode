class Solution {
    public int minTaps(int n, int[] ranges) {
        //GREEDY: this problem is like jump game II, we just have to build jump array on our own.
        int[] maxRight = new int[n+1];
        for(int i = 0; i <= n; i++){
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            
            //From left to right, gardens can be watered in one go
            maxRight[left] = Math.max(maxRight[left], right);
        }
        
        int endOfCurrLevel = 0, endOfNextLevel = 0, taps = 0;
        for(int i = 0; i <= n; i++){
            endOfNextLevel = Math.max(endOfNextLevel, maxRight[i]);
            if(i == endOfCurrLevel){
                taps++;
                endOfCurrLevel = endOfNextLevel;
                if(endOfNextLevel >= n) return taps;
            }
            
        }
        return -1;
       //DP: dp[i] represents the minimum number of tanks to water gardens till i
//         int[] dp = new int[n+1];
//         Arrays.fill(dp, n + 2);
//         dp[0] = 0;
//         for(int i = 0; i <= n; i++){
//             int left = Math.max(0, i - ranges[i]);
//             int right = Math.min(n, i + ranges[i]);
            
//             for(int j = left; j <= right; j++){
//                 dp[j] = Math.min(dp[j], dp[left] + 1);
//             }
//         }
//         return dp[n] == n + 2 ? -1 : dp[n];
    }
}